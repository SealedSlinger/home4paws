package com.ooad.home4paws.Service;

import com.ooad.home4paws.Entity.Report;
import com.ooad.home4paws.Repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    public Report updateReport(Long id, Report updatedReport) {
        return reportRepository.findById(id)
                .map(existing -> {
                    existing.setName(updatedReport.getName());
                    existing.setPhone(updatedReport.getPhone()); // ✅ added
                    existing.setDescription(updatedReport.getDescription());
                    existing.setLocation(updatedReport.getLocation());
                    existing.setFile(updatedReport.getFile());
                    return reportRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Report not found with id " + id));
    }


    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
