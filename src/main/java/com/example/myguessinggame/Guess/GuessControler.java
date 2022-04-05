package com.example.myguessinggame.Guess;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuessControler {
    @GetMapping("/guess")
    public GuessService startGame(){
        GuessService guessService= new GuessService();
        return guessService;
    }
}
