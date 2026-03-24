package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.DataExportFeature;

public interface ReportExporter {

    void exportToCSV();
    void exportToPDF();

    // New feature added later
    default void exportToJSON() {
        System.out.println("Exporting report in JSON format (Default).");
    }
}
