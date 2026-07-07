package com.cwa.lms.ls.service;

import com.cwa.lms.ls.dto.DocumentResponse;
import com.cwa.lms.ls.entity.Document;
import com.cwa.lms.ls.enums.DocumentType;
import com.cwa.lms.ls.mapper.DocumentMapper;
import com.cwa.lms.ls.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    private final DocumentMapper documentMapper;

    private final S3Client s3Client;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Value("${aws.bucket-name}")
    private String bucketName;

    @Value("${aws.access-key}")
    private String accessKey;

    public DocumentResponse upload(
            Long customerId,
            Long loanId,
            DocumentType type,
            MultipartFile file)
            throws IOException {

        String fileName = UUID.randomUUID()

                + "_"

                + file.getOriginalFilename();

        Path path = Paths.get(uploadDir, fileName);

        System.out.println("Upload Dir: " + uploadDir);
        System.out.println("Absolute Path: " + path.toAbsolutePath());

        Files.createDirectories(path.getParent());

        System.out.println("Directory Exists: " + Files.exists(path.getParent()));

        Files.copy(
                file.getInputStream(),
                path,
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("File saved: " + Files.exists(path));
        System.out.println("Saved to: " + path.toAbsolutePath());

        PutObjectRequest request =
                PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(accessKey)
                        .contentType(file.getContentType())
                        .build();

        s3Client.putObject(
                request,
                RequestBody.fromBytes(file.getBytes())
        );

        Document document = new Document();

        document.setCustomerId(customerId);
        document.setLoanId(loanId);
        document.setDocumentType(type);
        document.setOriginalFileName(
                file.getOriginalFilename());
        document.setStoredFileName(
                fileName);
        document.setFilePath(
                path.toString());

        document.setContentType(

                file.getContentType());

        document.setFileSize(

                file.getSize());

        document.setUploadedAt(

                LocalDateTime.now());

        documentRepository.save(document);

        return documentMapper.toResponse(document);

    }
}
