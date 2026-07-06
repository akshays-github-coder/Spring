package com.cwa.lms.ls.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanNumber;

    private Long customerId;

    @Enumerated(EnumType.STRING)
    private LoanType loanType;

    private BigDecimal loanAmount;

    private BigDecimal interestRate;

    private Integer tenureMonths;

    private BigDecimal monthlyIncome;

    private BigDecimal emi;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private String remarks;

    private LocalDateTime appliedDate;

    private LocalDateTime approvedDate;
}