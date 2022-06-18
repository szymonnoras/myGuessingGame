package com.example.myguessinggame.RandomNumber;

import com.example.myguessinggame.Guess.GuessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomNumberServiceTest {

    @Autowired
    RandomNumberService randomNumberService;

    @Test
    void isNumber(){
         randomNumberService = new RandomNumberService();
        assertNotNull(randomNumberService.getNumber());
    }

    @Test
    void isGreaterThan0andLessThan101(){
         randomNumberService = new RandomNumberService();
        assertTrue(randomNumberService.getNumber()>0 && randomNumberService.getNumber()<101);
    }
}