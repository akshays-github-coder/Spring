package com.cwa.lms.ls.repository;

import com.cwa.lms.ls.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
