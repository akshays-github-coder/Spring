package com.cwa.lms.ls.entity;

import com.cwa.lms.ls.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long loanId;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    private String originalFileName;

    private String storedFileName;

    private String filePath;

    private Long fileSize;

    private String contentType;

    private LocalDateTime uploadedAt;
}
