package com.meli.be_java_hisp_w18_g01.comparators;

import java.util.Comparator;

public class StringComparatorDesc implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}
