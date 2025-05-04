package com.animalsafenet.rescuepaw.model;

import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalReportDAO {

    private Long id;
    private String reportTitle;
    private String animalType;
    private ReportType reportType;
    private String description;
    private String location;
    private String imageURL;
    private boolean isResolved;
    private String contactPhone;
}
