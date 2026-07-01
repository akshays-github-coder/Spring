package com.cwa.spring.service;

import com.cwa.spring.entity.InsuranceOverview;
import com.cwa.spring.repository.InsuranceOverviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceOverviewService {

    private final InsuranceOverviewRepository insuranceOverviewRepository;

    public InsuranceOverview createInsuranceOverview(InsuranceOverview insuranceOverview) {
        return insuranceOverviewRepository.save(insuranceOverview);
    }

    public List<InsuranceOverview> getAllInsuranceOverviews() {
        return insuranceOverviewRepository.findAll();
    }

    public InsuranceOverview getInsuranceOverviewById(Long id) {
        return insuranceOverviewRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Policy not found!"));
    }

    public InsuranceOverview updateInsuranceOverviewById(Long id, InsuranceOverview insuranceOverview) {
        InsuranceOverview newInsuranceOverview = getInsuranceOverviewById(id);
        newInsuranceOverview.setInsuranceId(insuranceOverview.getInsuranceId());
        newInsuranceOverview.setInsuranceName(insuranceOverview.getInsuranceName());
        newInsuranceOverview.setInsuranceType(insuranceOverview.getInsuranceType());
        newInsuranceOverview.setInsuranceCategory(insuranceOverview.getInsuranceCategory());
        newInsuranceOverview.setInsuranceDescription(insuranceOverview.getInsuranceDescription());
        newInsuranceOverview.setInsurancePrice(insuranceOverview.getInsurancePrice());
        newInsuranceOverview.setInsuranceYear(insuranceOverview.getInsuranceYear());

        return insuranceOverviewRepository.save(newInsuranceOverview);
    }

    public String deleteInsuranceOverviewById(Long id) {
        insuranceOverviewRepository.deleteById(id);
        return "Insurance Overview has been deleted for " + id;
    }
}
