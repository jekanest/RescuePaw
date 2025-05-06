package com.animalsafenet.rescuepaw.model;

import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalReportDAO {

    private Long id;

    @NotBlank(message = "Report title is required")
    private String reportTitle;

    @NotBlank(message = "Animal type is required")
    private String animalType;

    @NotBlank(message = "Report type is required")
    private ReportType reportType;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Location is required")
    private String location;

    private String imageURL;
    private boolean isResolved;
    private String contactPhone;
}
