package com.example.myguessinggame.Guess;

import com.example.myguessinggame.HighScore.HighScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class GuessControler {

    @Autowired
    private final GuessService guessService = new GuessService();



    @GetMapping("/guess/{guess}")
    public String guessGame(@PathVariable final int guess){
        String response="ID: "+guessService.getUniqueIdService().getId()+
                        "<br/>number of tries: " + guessService.getCounter() +
                        "<br/>guess: "+guessService.startGame(guess)+
                        "<br/>time: "+guessService.getTotalTime()/1000000000 + " s";
        return response;
    }

   @GetMapping("/highscores")
    public List<HighScore> highScores(){
        return guessService.getTop10Scores();
    }
}
