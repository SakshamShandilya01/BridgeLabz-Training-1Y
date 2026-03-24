package com.gla.interfacesabstraction.DefaultMethodsinInterfaces.DataExportFeature;



public class SalesReport implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Sales Report exported as CSV.");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Sales Report exported as PDF.");
    }
}