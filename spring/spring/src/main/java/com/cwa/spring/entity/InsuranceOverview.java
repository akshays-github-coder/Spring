package com.cwa.spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insurance_overview")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceOverview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceId;
    private String insuranceName;
    private String insuranceType;
    private String insuranceCategory;
    private String insuranceDescription;
    private String insurancePrice;
    private String insuranceYear;
}
