package com.animalsafenet.rescuepaw.mapper;

import com.animalsafenet.rescuepaw.model.AnimalReportDAO;
import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.assertj.core.api.Assertions.assertThat;

class AnimalReportMapperTest {

    private final AnimalReportMapper mapper = Mappers.getMapper(AnimalReportMapper.class);


    @Test
    void toDTO() {
        AnimalReport entity = new AnimalReport();
        entity.setId(1L);
        entity.setReportTitle("Found dog next to the Bakery street");
        entity.setAnimalType("Dog");
        entity.setReportType(ReportType.FOUND);
        entity.setDescription("Walking around the street, looks friendly");
        entity.setLocation("Bakery Street");
        entity.setImageURL("http://example.com/dog.jpg");
        entity.setContactPhone("22675396");
        entity.setResolved(false);

        AnimalReportDAO dto = mapper.toDTO(entity);

        assertThat(dto.getReportTitle()).isEqualTo("Found dog next to the Bakery street");
        assertThat(dto.getReportType()).isEqualTo(ReportType.FOUND);
    }

    @Test
    void toEntity() {

        AnimalReportDAO dto = new AnimalReportDAO();
        dto.setReportTitle("Lost a cat");
        dto.setAnimalType("Cat");
        dto.setReportType(ReportType.LOST);
        dto.setDescription("Lost my cat next to Maxima Imanta");
        dto.setLocation("Aninnmuizas Street");
        dto.setImageURL("http://example.com/cat.jpg");
        dto.setContactPhone("22675396");
        dto.setResolved(false);

        AnimalReport entity = mapper.toEntity(dto);

        assertThat(entity.getAnimalType()).isEqualTo("Cat");
        assertThat(entity.getReportType()).isEqualTo(ReportType.LOST);
    }
}
