package com.cwa.lms.ls.dto;

import com.cwa.lms.ls.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentResponse {

    private Long id;

    private Long customerId;

    private Long loanId;

    private DocumentType documentType;

    private String originalFileName;

    private String storedFileName;

    private Long fileSize;

    private String contentType;

    private LocalDateTime uploadedAt;

    private String message;
}