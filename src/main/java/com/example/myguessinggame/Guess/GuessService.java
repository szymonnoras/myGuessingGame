package com.example.myguessinggame.Guess;

import com.example.myguessinggame.RandomNumber.RandomNumberService;
import com.example.myguessinggame.UniqueID.UniqueIdService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Random;

@Data
@Service
public class GuessService implements Serializable {

    private RandomNumberService randomNumberService;
    private UniqueIdService uniqueIdService;
    private Integer counter = 0;

    public GuessService() {
        this.randomNumberService = new RandomNumberService();
        this.uniqueIdService =new UniqueIdService();
    }

    public boolean startGame(){
        //have to create some kind of interface to get feedback from player.
        return false;
    }

    public void saveScoreToFile(){

    }
}
