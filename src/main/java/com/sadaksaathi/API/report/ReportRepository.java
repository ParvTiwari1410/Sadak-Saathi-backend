package com.sadaksaathi.API.report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    // We can add custom query methods here later
}