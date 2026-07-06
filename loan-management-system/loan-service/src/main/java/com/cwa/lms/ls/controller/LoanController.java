package com.cwa.lms.ls.controller;

import com.cwa.lms.ls.dto.LoanRequest;
import com.cwa.lms.ls.dto.LoanResponse;
import com.cwa.lms.ls.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> addLoan(
            @Valid @RequestBody LoanRequest loanRequest) {
        return ResponseEntity.ok(
                loanService.applyLoan(loanRequest)
        );
    }
}
