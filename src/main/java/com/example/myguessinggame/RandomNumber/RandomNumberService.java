package com.example.myguessinggame.RandomNumber;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Random;

@Data
@Service
public class RandomNumberService {

    private Integer number;


    public RandomNumberService() {
        Random random = new Random();
        this.number = random.nextInt(100)+1;
    }
}
