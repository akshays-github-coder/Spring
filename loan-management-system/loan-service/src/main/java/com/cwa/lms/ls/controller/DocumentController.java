package com.cwa.lms.ls.controller;

import com.cwa.lms.ls.dto.DocumentResponse;
import com.cwa.lms.ls.enums.DocumentType;
import com.cwa.lms.ls.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;

    @PostMapping("/upload")
    public ResponseEntity<DocumentResponse> upload(
            @RequestParam Long customerId,
            @RequestParam Long loanId,
            @RequestParam DocumentType documentType,
            @RequestParam MultipartFile file) throws IOException {

        return ResponseEntity.ok(
                service.upload(
                        customerId,
                        loanId,
                        documentType,
                        file));
    }
}
