package com.dh.be_java_hisp_w18_g10.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateHandler {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static LocalDate StringToDate(String stringDate){
        return LocalDate.parse(stringDate, formatter);
    }
    public static String DateToString(LocalDate date) {
        return date.format(formatter);
    }
    public static boolean isLocalDateAfter(LocalDate date, int ndays){
        Period period = Period.between(date, LocalDate.now());
        return period.getYears() > 0 || period.getMonths() > 0 || period.getDays() > ndays;
    }
}
