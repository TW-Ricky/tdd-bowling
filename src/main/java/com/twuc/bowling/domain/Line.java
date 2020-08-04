package com.twuc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Line {
    private final List<Frame> scoreTable;

    public Line(List<Frame> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public long calculate() {
        AtomicInteger result = new AtomicInteger(0);
        AtomicInteger index = new AtomicInteger(0);
        List<Integer> strike = new ArrayList<>();
        scoreTable.stream().forEach(item -> {
            index.getAndIncrement();
            result.updateAndGet(v -> v + Stream.of(item.getScores()).reduce(0, (sum, it) -> sum + it));
            if (item.getScores().length == 1) {
                strike.add(index.get());
            }
        });
        strike.stream().forEach(item -> {
            Integer extraScore = Stream.of(scoreTable.get(item + 1).getScores()).reduce(0, (sum, it) -> sum + it);
            result.updateAndGet(v -> v + extraScore);
        });
        return result.get();
    }

}
