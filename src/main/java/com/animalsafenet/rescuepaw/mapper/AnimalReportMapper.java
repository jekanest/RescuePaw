package com.animalsafenet.rescuepaw.mapper;

import com.animalsafenet.rescuepaw.model.AnimalReportDAO;
import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnimalReportMapper {

    AnimalReportDAO toDTO(AnimalReport animalReport);

    AnimalReport toEntity(AnimalReportDAO animalReportDAO);

}
