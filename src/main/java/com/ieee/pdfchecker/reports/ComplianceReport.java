package com.ieee.pdfchecker.reports;

import java.util.ArrayList;
import java.util.List;

public class ComplianceReport {
    private String fileName;
    private List<String> errors;
    private List<String> infoMessages;

    public ComplianceReport(String fileName) {
        this.fileName = fileName;
        this.errors = new ArrayList<>();
        this.infoMessages = new ArrayList<>();
    }

    public void addError(String error) {
        errors.add(error);
    }

    public void addInfo(String info) {
        infoMessages.add(info);
    }

    public boolean isCompliant() {
        return errors.isEmpty();
    }

    public String getReportSummary() {
        StringBuilder report = new StringBuilder();
        report.append("PDF: ").append(fileName).append("\n");

        if (!errors.isEmpty()) {
            report.append("Errors:\n");
            for (String error : errors) {
                report.append("- ").append(error).append("\n");
            }
        } else {
            report.append("No errors found. The document is compliant.\n");
        }

        if (!infoMessages.isEmpty()) {
            report.append("\nAdditional Info:\n");
            for (String info : infoMessages) {
                report.append("- ").append(info).append("\n");
            }
        }

        return report.toString();
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getInfoMessages() {
        return infoMessages;
    }
}