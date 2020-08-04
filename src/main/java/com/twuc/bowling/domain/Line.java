package com.twuc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Line {
    private final List<Frame> scoreTable;

    public Line(List<Frame> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public long calculate() {
        AtomicInteger result = new AtomicInteger(0);
        AtomicInteger index = new AtomicInteger(0);
        List<Integer> strikeIndex = new ArrayList<>();
        List<Integer> spareIndex = new ArrayList<>();
        scoreTable.stream().forEach(item -> {
            Integer score = Stream.of(item.getScores()).reduce(0, (sum, it) -> sum + it);
            result.updateAndGet(v -> v + score);
            if (item.getScores().length == 1) {
                strikeIndex.add(index.get());
            }
            if (score.equals(10) && item.getScores().length == 2) {
                spareIndex.add(index.get());
            }
            index.getAndIncrement();
        });
        calculateStrikeExtraScore(result, strikeIndex);
        calculateSpareExtraScore(result, spareIndex);
        return result.get();
    }

    private void calculateSpareExtraScore(AtomicInteger result, List<Integer> spare) {
        spare.stream().forEach(item -> {
            Integer extraScore = scoreTable.get(item + 1).getScores()[0];
            result.updateAndGet(v -> v + extraScore);
        });
    }

    private void calculateStrikeExtraScore(AtomicInteger result, List<Integer> strike) {
        strike.stream().forEach(item -> {
            Integer[] nextFrame = scoreTable.get(item + 1).getScores();
            Integer extraScore = Integer.valueOf(0);
            if (nextFrame.length == 2) {
                extraScore = Stream.of(nextFrame).reduce(0, (sum, it) -> sum + it);
            } else if (nextFrame.length == 1) {
                extraScore = nextFrame[0] + scoreTable.get(item + 2).getScores()[0];
            }
            Integer finalExtraScore = extraScore;
            result.updateAndGet(v -> v + finalExtraScore);
        });
    }

}
