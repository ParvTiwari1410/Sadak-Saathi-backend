package com.sadaksaathi.API.report;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    } 

    @GetMapping
    public ResponseEntity<List<Report>> getAllReports() {
        return ResponseEntity.ok(reportRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        return reportRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody CreateReportRequest reportRequest) {
        Report newReport = new Report();
        newReport.setTitle(reportRequest.getTitle());
        newReport.setLocation(reportRequest.getLocation());
        newReport.setStatus(reportRequest.getStatus());
        newReport.setSeverity(reportRequest.getSeverity());
        newReport.setDescription(reportRequest.getDescription());
        newReport.setPhotos(reportRequest.getPhotos()); // 👈 save photo URLs
        newReport.setSubmittedAt(LocalDateTime.now());

        Report savedReport = reportRepository.save(newReport);
        return ResponseEntity.ok(savedReport);
    }
}
