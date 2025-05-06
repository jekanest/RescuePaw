package com.animalsafenet.rescuepaw.service;

import com.animalsafenet.rescuepaw.repository.AnimalReportRepository;
import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AnimalReportServiceImpl implements AnimalReportService {

    private final AnimalReportRepository animalReportRepository;

    @Override
    public AnimalReport createReport(AnimalReport animalReport) {
        if (animalReport == null) {
            throw new IllegalArgumentException("Report cannot be null");
        }
        log.info("Creating new animal report: {}", animalReport);
        return animalReportRepository.save(animalReport);

    }

    @Override
    public AnimalReport updateReport(AnimalReport animalReport) {
        if (animalReport.getId() == null || !animalReportRepository.existsById(animalReport.getId())) {
            throw new IllegalArgumentException("Cannot update report. Report ID is missing or does not exist.");
        }
        log.info("Updating animal report with ID: {}", animalReport.getId());
        return animalReportRepository.save(animalReport);
    }

    @Override
    public void deleteReport(Long id) {
        if (!animalReportRepository.existsById(id)) {
            throw new EntityNotFoundException("Cannot delete report. Report with ID " + id + " does not exist.");
        }
        log.info("Deleting animal report with ID: {}", id);
        animalReportRepository.deleteById(id);

    }

    @Override
    public List<AnimalReport> getAllReports() {
        log.info("Fetching all animal reports");
        return animalReportRepository.findAll();
    }

    @Override
    public AnimalReport getReportById(Long id) {
        if (!animalReportRepository.existsById(id)) {
            throw new EntityNotFoundException("Cannot get report. Report with ID " + id + " does not exist.");
        }
        log.info("Fetching animal report by ID: {}", id);
        return animalReportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Report with ID " + id + " not found."));
    }

    @Override
    public List<AnimalReport> getReportByType(ReportType reportType) {
        log.info("Fetching animal reports by type: {}", reportType);
        return animalReportRepository.findByReportType(reportType);
    }
}
