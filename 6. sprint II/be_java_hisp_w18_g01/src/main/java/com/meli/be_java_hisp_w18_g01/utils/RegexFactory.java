package com.meli.be_java_hisp_w18_g01.utils;

public class RegexFactory {
    public static String specialCharsNotIncludedRegex ="([A-Z]|Á|É|Í|Ó|Í|Ú|[a-z]|á|é|í|ó|ú|[0-9])+";

    public static String getSpecialCharsNotIncludedRegex() {
        return specialCharsNotIncludedRegex;
    }

    public static void setSpecialCharsNotIncludedRegex(String specialCharsNotIncludedRegex) {
        RegexFactory.specialCharsNotIncludedRegex = specialCharsNotIncludedRegex;
    }
}
