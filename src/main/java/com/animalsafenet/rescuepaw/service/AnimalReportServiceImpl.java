package com.animalsafenet.rescuepaw.service;

import com.animalsafenet.rescuepaw.repository.AnimalReportRepository;
import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalReportServiceImpl implements AnimalReportService {

    private final AnimalReportRepository animalReportRepository;

    @Override
    public AnimalReport createReport(AnimalReport animalReport) {
        return null;
    }

    @Override
    public AnimalReport updateReport(AnimalReport animalReport) {
        return null;
    }

    @Override
    public void deleteReport(Long id) {

    }

    @Override
    public List<AnimalReport> getAllReports() {
        return List.of();
    }

    @Override
    public AnimalReport getReportById(Long id) {
        return null;
    }
}
