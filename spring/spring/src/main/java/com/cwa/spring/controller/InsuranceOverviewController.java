package com.cwa.spring.controller;

import com.cwa.spring.entity.InsuranceOverview;
import com.cwa.spring.service.InsuranceOverviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurance/overview")
@RequiredArgsConstructor
public class InsuranceOverviewController {

    private final InsuranceOverviewService insuranceOverviewService;

    @PostMapping
    public InsuranceOverview createInsuranceOverview(@RequestBody InsuranceOverview insuranceOverview) {
        return insuranceOverviewService.createInsuranceOverview(insuranceOverview);
    }

    @GetMapping
    public List<InsuranceOverview> getAllInsuranceOverviews() {
        return insuranceOverviewService.getAllInsuranceOverviews();
    }

    @GetMapping("/{id}")
    public InsuranceOverview getInsuranceOverviewById(@PathVariable Long id) {
        return insuranceOverviewService.getInsuranceOverviewById(id);
    }

    @PutMapping("/{id}")
    public InsuranceOverview updateInsuranceOverviewById(
            @PathVariable Long id,
            @RequestBody InsuranceOverview insuranceOverview) {
        return insuranceOverviewService.updateInsuranceOverviewById(id, insuranceOverview);
    }

    @DeleteMapping("/{id}")
    public String deleteInsuranceOverviewById(@PathVariable Long id) {
        return insuranceOverviewService.deleteInsuranceOverviewById(id);
    }
}
