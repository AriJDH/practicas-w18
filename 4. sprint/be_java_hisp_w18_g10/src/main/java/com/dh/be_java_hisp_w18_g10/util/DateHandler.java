package com.dh.be_java_hisp_w18_g10.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class DateHandler {
    public static Boolean compareDates(String date1, String date2){
        return null;
    }

    public static boolean showPostRecently(LocalDate postDate){
        Period periodo = Period.between(postDate, LocalDate.now());
        if(periodo.getYears() > 0 || periodo.getMonths()>0 || periodo.getDays() >14)
            return false;

        return true;
    }
}
