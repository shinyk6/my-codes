package com.lab02;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;


@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
    @Test 
    void createMember_성공() throws Exception { 
        String requestBody = "{\"name\":\"홍\", \"email\":\"hong@test.com\"}"; 
 
        mockMvc.perform(post("/members").contentType(MediaType.APPLICATION_JSON).content(requestBody)) 
                .andExpect(status().isCreated()) 
                .andExpect(jsonPath("$.name").value("홍길동")) 
                .andExpect(jsonPath("$.email").value("hong@test.com")); 
    } 
}
