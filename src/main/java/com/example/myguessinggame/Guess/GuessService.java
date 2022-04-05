package com.example.myguessinggame.Guess;

import com.example.myguessinggame.RandomNumber.RandomNumberService;
import com.example.myguessinggame.UniqueID.UniqueIdService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Data
@Service
public class GuessService {

    RandomNumberService randomNumberService;
    UniqueIdService uniqueIdService;

    public GuessService() {
        this.randomNumberService = new RandomNumberService();
        this.uniqueIdService =new UniqueIdService();
    }
}
