package com.example.myguessinggame.Guess;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuessServiceTest {

    @Autowired
    GuessService guessService;

    @Test
    void isNotNull() {
        guessService = new GuessService();
        assertNotNull(guessService);
    }

    @Test
    void containsNumberAndId() {
        guessService = new GuessService();
        assertTrue(guessService.getRandomNumberService().getNumber() != null && guessService.getUniqueIdService().getId() != null);
    }

    @Test
    void saveScoreToFile() {
        guessService = new GuessService();

    }
}