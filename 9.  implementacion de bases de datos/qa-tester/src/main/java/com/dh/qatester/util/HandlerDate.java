package com.dh.qatester.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class HandlerDate {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static LocalDate StringToDate(String stringDate){
        return LocalDate.parse(stringDate, formatter);
    }

    public static String DateToString(LocalDate date) {
        return date.format(formatter);
    }

    public static boolean isLocalDateAfter(LocalDate date, int days){
        Period period = Period.between(date, LocalDate.now());
        return period.getDays() < days && period.getMonths() == 0 && period.getYears() == 0;
    }

}
