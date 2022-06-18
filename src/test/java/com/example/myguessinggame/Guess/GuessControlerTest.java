package com.example.myguessinggame.Guess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class GuessControlerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    GuessControler guessController;

    @Test
    void guessGame() throws Exception {
        MvcResult result=mockMvc.perform(get("/guess/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertTrue(result.getResponse().getContentAsString().contains("ID:"));
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("number of tries:"));
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("guess:"));
        Assertions.assertTrue(result.getResponse().getContentAsString().contains("time:"));
    }

    @Test
    void start() throws Exception {
        MvcResult result=mockMvc.perform(get("/start"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertTrue(result.getResponse().getContentAsString().matches("\"[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}\""));
    }

    @Test
    void highScores() throws Exception {
        this.mockMvc
                .perform(get("/highscores"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id",matchesRegex("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}")))
                .andExpect(jsonPath("$[0].tries",isA(Integer.TYPE)))
                .andExpect(jsonPath("$[0].time",isA(Integer.TYPE)));
    }
}