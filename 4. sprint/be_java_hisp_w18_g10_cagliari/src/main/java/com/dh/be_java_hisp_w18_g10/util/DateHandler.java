package com.dh.be_java_hisp_w18_g10.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class DateHandler {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static Boolean compareDates(String date1, String date2){
        return null;
    }
    public static LocalDate StringToDate(String stringDate){
        return LocalDate.parse(stringDate, formatter);
    }
    public static String DateToString(LocalDate date) {
        return date.format(formatter);
    }
    public static boolean showPostRecently(LocalDate postDate){
        Period periodo = Period.between(postDate, LocalDate.now());
        if(periodo.getYears() > 0 || periodo.getMonths()>0 || periodo.getDays() >14)
            return false;
        return true;
    }
}
