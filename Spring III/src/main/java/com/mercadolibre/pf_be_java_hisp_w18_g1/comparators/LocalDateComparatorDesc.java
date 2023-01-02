package com.mercadolibre.pf_be_java_hisp_w18_g1.comparators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;

@Component
public class LocalDateComparatorDesc implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate date1, LocalDate date2) {
        return date2.compareTo(date1);
    }
}
