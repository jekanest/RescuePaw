package com.animalsafenet.rescuepaw.service;

import com.animalsafenet.rescuepaw.repository.AnimalReportRepository;
import com.animalsafenet.rescuepaw.repository.entity.AnimalReport;
import com.animalsafenet.rescuepaw.repository.entity.ReportType;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalReportServiceImplTest {

    @Mock
    private AnimalReportRepository animalReportRepository;

    @InjectMocks
    private AnimalReportServiceImpl animalReportService;

    private AnimalReport testReport;

    @BeforeEach
    public void beforeEach(){
        testReport = createAnimalReport(1L, "Lost dog", "Dog", ReportType.LOST, "Black Labrador", "Central Park", "http://image.com/dog.jpg", false, "123456789");
    }

    @Test
    void createReport() {

        when(animalReportRepository.save(any(AnimalReport.class))).thenReturn(testReport);

        AnimalReport saved = animalReportService.createReport(testReport);

        assertNotNull(saved);
        assertEquals("Lost dog", saved.getReportTitle());
        assertEquals("Dog", saved.getAnimalType());
        assertEquals("Black Labrador", saved.getDescription());
        assertEquals(ReportType.LOST, saved.getReportType());
        //assertEquals(testReport,saved);
        verify(animalReportRepository, times(1)).save(testReport);
    }

    @Test
    void createReport_withNullReport_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> animalReportService.createReport(null));
    }

    @Test
    void updateReport() {
        when(animalReportRepository.existsById(testReport.getId())).thenReturn(true);
        when(animalReportRepository.save(any(AnimalReport.class))).thenReturn(testReport);
        AnimalReport updated = animalReportService.updateReport(testReport);

        assertEquals("Lost dog", updated.getReportTitle());
        verify(animalReportRepository, times(1)).existsById(testReport.getId());
        verify(animalReportRepository, times(1)).save(testReport);
    }

    @Test
    void updateReport_invalidId_throwsException() {
        when(animalReportRepository.existsById(testReport.getId())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> animalReportService.updateReport(testReport));
    }

    @Test
    void deleteReport() {
        when(animalReportRepository.existsById(testReport.getId())).thenReturn(true);
        doNothing().when(animalReportRepository).deleteById(1L);

        animalReportService.deleteReport(1L);
        verify(animalReportRepository, times(1)).existsById(1L);
        verify(animalReportRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteReport_InvalidId_throwsException() {
        when(animalReportRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> animalReportService.deleteReport(1L));
    }

    @Test
    void getAllReports() {
        when(animalReportRepository.findAll()).thenReturn(List.of(testReport));

        List<AnimalReport> allReports = animalReportService.getAllReports();

        assertEquals(1, allReports.size());
        assertEquals("Lost dog", allReports.get(0).getReportTitle());
    }

    @Test
    void getReportById() {
        when(animalReportRepository.existsById(testReport.getId())).thenReturn(true);
        when(animalReportRepository.findById(anyLong())).thenReturn(Optional.of(testReport));

        AnimalReport reportById = animalReportService.getReportById(1L);

        assertNotNull(reportById);
        assertEquals("Lost dog", reportById.getReportTitle());
        verify(animalReportRepository, times(1)).existsById(1L);
        verify(animalReportRepository).findById(1L);
    }

    @Test
    void getReportById_invalidId_throwsException() {
        when(animalReportRepository.existsById(1L)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> animalReportService.getReportById(1L));
    }

    @Test
    void getReportByType() {
        when(animalReportRepository.findByReportType(ReportType.LOST))
                .thenReturn(List.of(testReport));

        List<AnimalReport> reportsByType = animalReportService.getReportByType(ReportType.LOST);

        assertNotNull(reportsByType);
        assertEquals(1, reportsByType.size());
        assertEquals(ReportType.LOST, reportsByType.get(0).getReportType());
        verify(animalReportRepository, times(1)).findByReportType(ReportType.LOST);

    }

    private AnimalReport createAnimalReport(Long id, String reportTitle, String animalType, ReportType reportType, String description, String location, String imageURL, boolean isResolved, String phone) {
        testReport = new AnimalReport();
        testReport.setId(id);
        testReport.setReportTitle(reportTitle);
        testReport.setAnimalType(animalType);
        testReport.setReportType(reportType);
        testReport.setDescription(description);
        testReport.setLocation(location);
        testReport.setImageURL(imageURL);
        testReport.setResolved(isResolved);
        testReport.setContactPhone(phone);
        return testReport;
    }
}
