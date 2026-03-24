package com.gla.interfacesabstraction.StaticMethodsinInterfaces.DateFormatUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateUtils {

    static String formatDate(LocalDate date, String pattern) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(pattern);

        return date.format(formatter);
    }
}