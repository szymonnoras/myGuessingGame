package com.example.myguessinggame.Guess;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GuessServiceTest {

    @Test
    void isNotNull() {
        GuessService guessService = new GuessService();
        assertNotNull(guessService);
    }

    @Test
    void containsNumberAndId() {
        GuessService guessService = new GuessService();
        assertTrue(guessService.getRandomNumberService().getNumber() != null && guessService.getUniqueIdService().getId() != null);
    }
}