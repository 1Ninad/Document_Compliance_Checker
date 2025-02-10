package com.ieee.pdfchecker.controller;

import com.ieee.pdfchecker.reports.ComplianceReport;
import com.ieee.pdfchecker.services.PdfService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:5173") // Allow frontend access
@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ComplianceReport> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            File tempFile = File.createTempFile("uploaded", ".pdf");
            file.transferTo(tempFile);

            ComplianceReport report = pdfService.processPdf(tempFile);

            return ResponseEntity.ok(report); // ✅ Return ComplianceReport as JSON
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}