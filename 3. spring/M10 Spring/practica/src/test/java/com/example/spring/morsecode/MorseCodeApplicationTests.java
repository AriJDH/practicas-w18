package com.example.spring.morsecode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MorseCodeApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void shouldDecodeWord() throws Exception {
    performTest(".... --- .-.. .-", "HOLA");
    performTest("... .--. .-. .. -. --.", "SPRING");
  }

  @Test
  void shouldDecodePhrase() throws Exception {
    performTest("-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .", "MERCADO LIBRE");
  }

  private void performTest(String morseCode, String text) throws Exception {
    this.mockMvc.perform(get("/" + morseCode))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(text)));
  }

}
