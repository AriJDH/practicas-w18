package com.example.concesionaria.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HandleLocalDate {

    public static LocalDate parse(String s) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static boolean compareDates(LocalDate since, LocalDate to, LocalDate date) {
        return date.isAfter(since) && date.isBefore(to);
    }

}
