package com.example.myguessinggame.UniqueID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesRegex;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class UniqueIdControllerTest {

    @Autowired
    private UniqueIdController uniqueIdController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void valueLoads() throws Exception{
        assertThat(uniqueIdController).isNotNull();
    }


    /**
     * @throws Exception
     * test checks if endpoint returns string which matches UUID pattern
     */
    @Test
    public void showID() throws Exception{
        this.mockMvc
                .perform(get("/start"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(matchesRegex("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")));
    }
}