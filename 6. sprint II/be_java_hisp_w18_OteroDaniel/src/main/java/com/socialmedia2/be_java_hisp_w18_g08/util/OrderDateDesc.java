package com.socialmedia2.be_java_hisp_w18_g08.util;

import java.time.LocalDate;
import java.util.Comparator;

public class OrderDateDesc implements Comparator<LocalDate> {

    @Override
    public int compare(LocalDate o1, LocalDate o2) {
        return o2.compareTo(o1);
    }
}
