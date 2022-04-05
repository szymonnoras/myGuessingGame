package com.example.myguessinggame.RandomNumber;

import com.example.myguessinggame.Guess.GuessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberServiceTest {

    @Test
    void isNumber(){
        RandomNumberService randomNumberService = new RandomNumberService();
        assertTrue(randomNumberService.getNumber() instanceof Integer);
    }

    @Test
    void isGreaterThan0andLessThan101(){
        RandomNumberService randomNumberService = new RandomNumberService();
        assertTrue(randomNumberService.getNumber()>0 && randomNumberService.getNumber()<101);
    }
}