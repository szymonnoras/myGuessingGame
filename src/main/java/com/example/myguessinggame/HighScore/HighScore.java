package com.example.myguessinggame.HighScore;

import lombok.Data;

import java.io.Serializable;

@Data
public class HighScore implements Serializable {
    private final String id;
    private final int tries;
    private final long time;

    public HighScore(String id, int tries, long time) {
        this.id = id;
        this.tries = tries;
        this.time = time/1_000_000_000;
    }

    @Override
    public String toString() {
        return "HighScore{" +
                "id='" + id + '\'' +
                ", tries=" + tries +
                ", time=" + time +
                '}';
    }


}
