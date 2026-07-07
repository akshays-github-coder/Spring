package com.cwa.lms.ls.dto;

import com.cwa.lms.ls.enums.LoanType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @NotNull
    private Long customerId;

    @NotNull
    private LoanType loanType;

    @NotNull
    @DecimalMin("10000")
    private BigDecimal loanAmount;

    @NotNull
    @Min(6)
    private Integer tenureMonths;

    @NotNull
    private BigDecimal monthlyIncome;
}
