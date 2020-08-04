package com.twuc.bowling.domain;

import java.util.Arrays;

public class Frame {
    private Integer[] scores;

    public Frame(Integer ...scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "scores=" + Arrays.toString(scores) +
                '}';
    }

    public Integer[] getScores() {
        return scores;
    }

    public void setScores(Integer[] scores) {
        this.scores = scores;
    }
}
