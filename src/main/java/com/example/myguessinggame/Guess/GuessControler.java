package com.example.myguessinggame.Guess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuessControler {

    @Autowired
    private GuessService guessService;



    @GetMapping("/guess")
    public GuessService gameVariables(){
        guessService = new GuessService();
        return guessService;
    }

    @GetMapping("/hiscores")
    public List<GuessService> highScores(){
        List<GuessService> guessServices = new ArrayList<>();
        return guessServices;
    }
}
