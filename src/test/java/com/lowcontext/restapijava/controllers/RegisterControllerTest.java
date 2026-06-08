package com.lowcontext.restapijava.controllers;

import com.lowcontext.restapijava.models.dto.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterController() throws Exception {
        RegisterRequest regReq = new RegisterRequest(
            "jack hanma",
            "jack@gmail.com",
            "jack123",
            "jack123"
        );

        String jsonBody = objectMapper.writeValueAsString(regReq);

        this.mockMvc
            .perform(
                MockMvcRequestBuilders.post("/api/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonBody)
            )
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
