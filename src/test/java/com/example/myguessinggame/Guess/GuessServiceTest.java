package com.example.myguessinggame.Guess;

import com.example.myguessinggame.HighScore.HighScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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

    @Test
    void startGameReturnsProperString(){
        guessService = new GuessService();
        assertTrue(guessService.startGame(5).equals("too big") || guessService.startGame(5).equals("too small") ||guessService.startGame(5).equals("winner"));
    }

    @Test
    void getDataIsNotEmpty(){
        guessService = new GuessService();
        assertNotNull(guessService.getData());
    }

    @Test
    void parseDataToScoresIsNotEmpty(){
        guessService = new GuessService();
        assertNotNull(guessService.parseDataToScores().get(0));
    }

    @Test
    void getTop10Scores(){
        guessService = new GuessService();
        assertEquals(10, guessService.getTop10Scores().size());
    }

    @Test
    void removeWorstScore(){
        guessService = new GuessService();
        List<HighScore> list=guessService.parseDataToScores();
        int size=guessService.parseDataToScores().size();
        assertEquals(size-1, guessService.removeWorstScore(list).size());
    }

    @Test
    void sort(){
        guessService = new GuessService();
        List<HighScore> list=guessService.parseDataToScores();
        List<HighScore> list2=guessService.parseDataToScores();
        guessService.sort(list);
        guessService.sort(list2);
        assertEquals(list, list2);
    }
}