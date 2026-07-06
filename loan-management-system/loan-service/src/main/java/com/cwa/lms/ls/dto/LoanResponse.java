package com.cwa.lms.ls.dto;

import com.cwa.lms.ls.entity.LoanStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@Builder
public class LoanResponse {
    private String loanNumber;
    private LoanStatus status;
    private BigDecimal emi;
}
