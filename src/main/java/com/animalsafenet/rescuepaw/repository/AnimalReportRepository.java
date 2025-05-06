package com.animalsafenet.rescuepaw.repository;

import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalReportRepository extends JpaRepository<AnimalReport, Long> {

    List<AnimalReport> findByReportType(ReportType reportType);
}
