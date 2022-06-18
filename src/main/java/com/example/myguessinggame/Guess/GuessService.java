package com.example.myguessinggame.Guess;

import com.example.myguessinggame.HighScore.HighScore;
import com.example.myguessinggame.RandomNumber.RandomNumberService;
import com.example.myguessinggame.UniqueID.UniqueIdService;
import com.opencsv.CSVReader;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Data
@Service
public class GuessService implements Serializable {

    private RandomNumberService randomNumberService;
    private UniqueIdService uniqueIdService;
    private Integer counter = 0;
    private long startTime;
    private long totalTime;

    public GuessService() {
        this.randomNumberService = new RandomNumberService();
        this.uniqueIdService = new UniqueIdService();
        this.startTime = System.nanoTime();
        this.totalTime = 0;
    }

    public String startGame(int guess) {
        if (guess > this.randomNumberService.getNumber()) {
            counter++;
            totalTime = System.nanoTime() - startTime;
            return "too big";
        } else if (guess < this.randomNumberService.getNumber()) {
            counter++;
            totalTime = System.nanoTime() - startTime;
            return "too small";
        } else {
            totalTime = System.nanoTime() - startTime;
            saveScoreToFile();
            return "winner";
        }
    }

    public void saveScoreToFile() {
        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("src/main/resources/static/highscores.csv",true));
            writer.append("\n"+this.counter+","+this.totalTime/1_000_000_000+","+this.uniqueIdService.getId());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getData() {
        List<String[]> allScores = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/main/resources/static/highscores.csv");
            CSVReader csvReader = new CSVReader(fileReader);
            allScores = csvReader.readAll();
            allScores.remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allScores;
    }

    public List<HighScore> parseDataToScores(){
        List<String[]> dataToParse=getData();
        List<HighScore> highScores=new ArrayList<>();
        for (String[] row : dataToParse) {
            highScores.add(new HighScore(row[2], Integer.parseInt(row[0]), Long.parseLong(row[1])*1_000_000_000));
        }
        return highScores;
    }

    public List<HighScore> getTop10Scores(){
        List<HighScore> scores=parseDataToScores();
        List<HighScore> top10Scores;
        do{
            top10Scores=removeWorstScore(scores);
        }while (top10Scores.size()!=10);

        sort(top10Scores);
        return top10Scores;
    }

    public List<HighScore> removeWorstScore(List<HighScore> scores){
        int index=0;
        int max=0;
        for (int i=0; i<scores.size(); i++) {
            if(max<scores.get(i).getTries()){
                max=scores.get(i).getTries();
                index=i;
            }
        }
        scores.remove(index);
        return scores;
    }

    public void sort(List<HighScore> list){
        HighScore temp;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if(list.get(j).getTries()>list.get(j+1).getTries()){
                    temp=list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
}
