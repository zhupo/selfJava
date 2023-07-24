package core;

import java.util.Arrays;

public class Score {
    private int[] scores;

    public Score(int[] scores) {
        this.scores = scores.clone();
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
