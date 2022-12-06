package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
class RomanNumeralsApplicationTests {

    @Nested
    @DisplayName("GET /{number}")
    class toRoman {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("Success - number 1 return I")
        void Test1() throws Exception {
            performTest("1", "I");
        }

        @Test
        @DisplayName("Success - number 3 return III")
        void Test2() throws Exception {
            performTest("3", "III");
        }

        @Test
        @DisplayName("Success - number 5 return V")
        void Test3() throws Exception {
            performTest("5", "V");
        }

        @Test
        @DisplayName("Success - number 7 return VII")
        void Test4() throws Exception {
            performTest("7", "VII");
        }

        @Test
        @DisplayName("Success - number 10 return X")
        void Test5() throws Exception {
            performTest("10", "X");
        }

        @Test
        @DisplayName("Success - number 50 return L")
        void Test6() throws Exception {
            performTest("50", "L");
        }

        @Test
        @DisplayName("Not Success - 400 Bad Request")
        void Test7() throws Exception {

            String decimal = "e";
            this.mockMvc.perform(get("/" + decimal))
                    .andDo(print())
                    .andExpect(status().isBadRequest());
        }

        private void performTest(String decimal, String roman) throws Exception {
            this.mockMvc.perform(get("/" + decimal))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString(roman)));
        }
    }

}
