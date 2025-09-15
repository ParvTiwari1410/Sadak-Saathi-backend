package com.sadaksaathi.API.report;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> getReportById(@PathVariable Long id) {
        return ResponseEntity.ok(reportRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody CreateReportRequest reportRequest) {
        Report newReport = new Report();
        newReport.setTitle(reportRequest.getTitle());
        newReport.setLocation(reportRequest.getLocation());
        newReport.setStatus(reportRequest.getStatus());
        newReport.setSeverity(reportRequest.getSeverity());
        newReport.setDescription(reportRequest.getDescription());
        newReport.setImageUrl(reportRequest.getImageUrl()); // Correctly sets the image URL
        newReport.setSubmittedAt(LocalDateTime.now());

        Report savedReport = reportRepository.save(newReport);
        return ResponseEntity.ok(savedReport);
    }
}