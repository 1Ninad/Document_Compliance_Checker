package com.example.spring;

import com.ieee.pdfchecker.reports.ComplianceReport;
import com.ieee.pdfchecker.rules.RuleEngine;

import java.io.File;
public class PdfChecker {
    private final RuleEngine ruleEngine;
    public PdfChecker() {
        this.ruleEngine = new RuleEngine();
    }

    public ComplianceReport analyzeFile(File file) {
        return ruleEngine.checkCompliance(file);
    }
}