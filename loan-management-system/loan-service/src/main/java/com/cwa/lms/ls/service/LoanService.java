package com.cwa.lms.ls.service;

import com.cwa.lms.ls.client.UserClient;
import com.cwa.lms.ls.dto.LoanRequest;
import com.cwa.lms.ls.dto.LoanResponse;
import com.cwa.lms.ls.dto.UserResponse;
import com.cwa.lms.ls.entity.Loan;
import com.cwa.lms.ls.enums.LoanStatus;
import com.cwa.lms.ls.mapper.LoanMapper;
import com.cwa.lms.ls.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserClient userClient;

    @Autowired
    private LoanMapper loanMapper;

    public LoanResponse applyLoan(
            LoanRequest request) {

        UserResponse user =
                userClient.getUser(
                        request.getCustomerId());

        if(user == null) {
            throw new RuntimeException(
                    "User not found");
        }

        Loan loan = new Loan();

        loan.setCustomerId(
                request.getCustomerId());

        loan.setLoanAmount(
                request.getLoanAmount());

        loan.setMonthlyIncome(
                request.getMonthlyIncome());

        loan.setTenureMonths(
                request.getTenureMonths());

        loan.setStatus(
                LoanStatus.PENDING);

        loan.setAppliedDate(
                LocalDateTime.now());

        Loan saved =
                loanRepository.save(loan);

        return loanMapper.toResponse(saved);
    }
}
