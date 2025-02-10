package com.ieee.pdfchecker.models;


public class PdfResponse {
    private String message;
    private boolean compliant;

    public PdfResponse(String message, boolean compliant) {
        this.message = message;
        this.compliant = compliant;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCompliant() {
        return compliant;
    }
}