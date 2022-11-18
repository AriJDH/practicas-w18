package morse_code.morse_code.controllers;

import javax.websocket.server.PathParam;
import morse_code.morse_code.services.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

  @GetMapping("/morse/{text}")
  public String morseConvertor(@PathVariable String text) {
    Morse service = new Morse();
    return service.getMorseCode(text);
  }
}
