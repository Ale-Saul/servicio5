package com.example.servicio5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class FraudControllerTest {

    private MockMvc mockMvc;

    @Test
    void testCheckFraud() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/checkFraud")
                        .param("cardNumber", "1234567812345678"))
                .andExpect(status().isOk());
    }

    @Test
    void testCardNotInBlacklist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/checkFraud")
                        .param("cardNumber", "1111222233334444"))
                .andExpect(status().isOk());
    }
}