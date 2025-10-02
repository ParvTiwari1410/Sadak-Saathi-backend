package com.sadaksaathi.API.report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // Custom queries can be added later
}
