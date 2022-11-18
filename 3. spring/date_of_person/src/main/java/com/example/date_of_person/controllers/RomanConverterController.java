package com.example.date_of_person.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateOfPersonController {

  @PostMapping("/convertDate/{day}/{month}/{year}")
  public String convertDate(
    @PathVariable String day,
    String month,
    String year
  ) {
    // 01/01/2000
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dateBorn = LocalDate.parse(day + "/" + month + "/" + year, fmt);
    LocalDate dateNow = LocalDate.now();

    Period period = Period.between(dateBorn, dateNow);
    String result =
      "Tu edad es: %s años, %s meses y %s días" +
      period.getYears() +
      period.getMonths() +
      period.getDays();

    return (result);
  }
}
