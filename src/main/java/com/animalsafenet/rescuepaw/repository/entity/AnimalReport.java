package com.animalsafenet.rescuepaw.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animal_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportTitle;

    @Column(nullable = false)
    private String animalType;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    @Column(nullable = false)
    private String description;

    private String location;

    private String imageURL;

    private boolean isResolved = false;

    private String contactPhone;







}
