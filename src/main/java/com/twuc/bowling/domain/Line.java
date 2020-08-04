package com.twuc.bowling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private List<Frame> scoreTable;

    public Line(List<Frame> scoreTable) {
        this.scoreTable = scoreTable;
    }

    public long calculate() {
        List<Integer> frames = new ArrayList<>();
        scoreTable.stream().forEach( item -> frames.add(item.getFirstThrow() + item.getSecondThrow()));
        long result = frames.stream().reduce(0, (sum, item) -> {
            sum += item;
            return sum;
        });
        return result;
    }

}
