package morse_code.morse_code.services;

import java.util.HashMap;
import java.util.Map;

public class Morse {
  private Map<String, Character> morse = new HashMap<String, Character>();
  private String[] codes = {
    ".-",
    "-...",
    "-.-.",
    "-..",
    ".",
    "..-.",
    "--.",
    "....",
    "..",
    ".---",
    "-.-",
    ".-..",
    "--",
    "-.",
    "---",
    ".--.",
    "--.-",
    ".-.",
    "...",
    "-",
    "..-",
    "...-",
    ".--",
    "-..-",
    "-.--",
    "--..",
    "|",
  };

  public String getMorseCode(String text) {
    for (int i = 0; i < codes.length; i++) {
      morse.put(codes[i], (char) ('a' + i));
    }

    String decoded = "";
    String[] arr = text.split(" ");
    System.out.println(arr.length);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
      decoded += morse.get(arr[i]);
    }
    return decoded.toUpperCase();
  }
}
