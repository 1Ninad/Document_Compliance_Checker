package com.ieee.pdfchecker.services;

import com.ieee.pdfchecker.reports.ComplianceReport;
import com.ieee.pdfchecker.rules.RuleEngine;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PdfService {

    private final RuleEngine ruleEngine;

    public PdfService(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public ComplianceReport processPdf(File file) {
        return ruleEngine.checkCompliance(file); // ✅ Now returns ComplianceReport
    }

}
