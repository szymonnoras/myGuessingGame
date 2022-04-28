package com.example.myguessinggame.Guess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuessControlerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    GuessControler guessController;

    @Test
    void gameVariables() throws Exception {
        this.mockMvc
                .perform(get("/guess"))
                .andExpect(status().isOk());

    }

    @Test
    void highScores() {
    }
}