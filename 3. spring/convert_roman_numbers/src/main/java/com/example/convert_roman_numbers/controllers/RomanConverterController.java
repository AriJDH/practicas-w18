package com.example.convert_roman_numbers.controllers;

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
public class RomanConverterController {
  private Map<String, String> numbers = new HashMap<String, String>() {

    {
      put("0", "This value doesn't exists");
      put("1", "I");
      put("2", "II");
      put("3", "III");
      put("4", "IV");
      put("5", "V");
      put("6", "VI");
      put("7", "VII");
      put("8", "VIII");
      put("8", "IX");
      put("10", "X");
      put("11", "XI");
      put("12", "XII");
      put("13", "XIII");
      put("14", "XIV");
      put("15", "XV");
      put("50", "L");
      put("100", "C");
      put("500", "D");
      put("1000", "M");
    }
  };

  @GetMapping("/converter/decimal/{number}")
  public String converterNumber(@PathVariable String number) {
    System.out.println(numbers);
    return ("The Roman number is: " + this.numbers.get(number));
  }

  @PostMapping("/convertDate/{day}/{month}/{year}")
  public String convertDate(
    @PathVariable String day,
    String month,
    String year
  ) {
    // 01/01/2000
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate fechaNac = LocalDate.parse(day + "/" + month + "/" + year, fmt);
    LocalDate ahora = LocalDate.now();

    Period periodo = Period.between(fechaNac, ahora);
    String resultado =
      "Tu edad es: %s años, %s meses y %s días" +
      periodo.getYears() +
      periodo.getMonths() +
      periodo.getDays();

    return (resultado);
  }
}
