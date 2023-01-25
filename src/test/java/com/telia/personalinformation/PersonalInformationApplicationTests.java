package com.telia.personalinformation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telia.personalinformation.model.dto.request.PersonalInformationEntityRequestDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This test class is used to showcase spring Integration testing capability. More test cases can be added to handle different business scenarios.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("integration-test")
class PersonalInformationApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUserWithValidInput() throws Exception {
        String firstName = "firstName";
        PersonalInformationEntityRequestDto user = PersonalInformationEntityRequestDto.builder().firstName(firstName).lastName("lastName").emailAddress("test@gmail.com").dateOfBirth("23-08-1991").build();
        mockMvc.perform(post("/users/create/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.personalNumber").isNumber())
                .andExpect(jsonPath("$.personalNumber").isNotEmpty())
                .andExpect(jsonPath("$.firstName").value(firstName));
    }

    @Test
    void testCreateUserWithInValidInput() throws Exception {
        PersonalInformationEntityRequestDto user = PersonalInformationEntityRequestDto.builder().firstName("firstName").lastName("lastName").emailAddress("test.com").dateOfBirth("23-08-1991").build();
        mockMvc.perform(post("/users/create/")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validation Error"));
    }


}
