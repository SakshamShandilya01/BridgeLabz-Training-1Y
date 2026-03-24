package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.DataExportFeature;

public class ExportApp {

    public static void main(String[] args) {

        ReportExporter report = new SalesReport();

        report.exportToCSV();
        report.exportToPDF();
        report.exportToJSON(); // new feature works without changes
    }
}
