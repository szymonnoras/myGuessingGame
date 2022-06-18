package com.example.myguessinggame;

import com.example.myguessinggame.Guess.GuessControler;
import com.example.myguessinggame.Guess.GuessService;
import com.example.myguessinggame.HighScore.HighScore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;
import java.util.logging.Handler;

@SpringBootApplication
public class MyGuessingGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyGuessingGameApplication.class, args);
        GuessService guessService= new GuessService();


    }

}
