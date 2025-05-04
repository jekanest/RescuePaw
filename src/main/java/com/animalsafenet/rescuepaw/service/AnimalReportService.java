package com.animalsafenet.rescuepaw.service;

import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import java.util.List;

public interface AnimalReportService {

    AnimalReport createReport(AnimalReport animalReport);
    AnimalReport updateReport(AnimalReport animalReport);
    void deleteReport(Long id);
    List<AnimalReport> getAllReports();
    AnimalReport getReportById(Long id);

}
