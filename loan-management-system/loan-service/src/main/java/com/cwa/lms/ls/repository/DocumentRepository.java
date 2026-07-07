package com.cwa.lms.ls.repository;

import com.cwa.lms.ls.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}
