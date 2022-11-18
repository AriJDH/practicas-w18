package com.example.blog.utils.dates;

import lombok.AllArgsConstructor;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateManager {
    private DateTimeFormatter dateFormatter;

    public DateManager(String pattern){
        this.dateFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    public LocalDate today(){
         return LocalDate.now();
     }

     public String dateToString(LocalDate date){
        return date.format(dateFormatter);
     }

     public LocalDate dateFromString(String date){
        try{
            return LocalDate.parse(date,dateFormatter);
        }catch(Exception e){
            throw new DateConversionException("Date could not be parsed: incorrect format.");
         }
     }
}
