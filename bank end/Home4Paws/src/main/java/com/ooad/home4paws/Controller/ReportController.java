package com.ooad.home4paws.Controller;

import com.ooad.home4paws.Entity.Report;
import com.ooad.home4paws.Service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173") // allow Vite frontend
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // CREATE a new report
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        System.out.println("Received report: " + report.getName() + ", " + report.getDescription());
        Report savedReport = reportService.createReport(report);
        return ResponseEntity.ok(savedReport);
    }

    // GET all reports
    @GetMapping
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // GET a single report by ID
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE an existing report
    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody Report updatedReport) {
        Report report = reportService.updateReport(id, updatedReport);
        return ResponseEntity.ok(report);
    }

    // DELETE a report
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
