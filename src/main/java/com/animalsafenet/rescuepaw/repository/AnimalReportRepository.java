package com.animalsafenet.rescuepaw.repository;

import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalReportRepository extends JpaRepository<AnimalReport, Long> {

}
