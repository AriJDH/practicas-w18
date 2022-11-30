package com.meli.be_java_hisp_w18_g01.comparators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;

@Component
public final class LocalDateComparatorAsc implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate date1, LocalDate date2) {
        return date1.compareTo(date2);
    }
}