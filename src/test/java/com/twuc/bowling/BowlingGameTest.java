package com.twuc.bowling;

import com.twuc.bowling.domain.Frame;
import com.twuc.bowling.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {


    @Test
    public void should_return_score_when_calculate_given_a_line_without_strike_and_spare() {
        List<Frame> scoreTable = new ArrayList<>();
        scoreTable.add(new Frame(1, 1));
        scoreTable.add(new Frame(2, 2));
        scoreTable.add(new Frame(3, 3));
        scoreTable.add(new Frame(4, 4));
        scoreTable.add(new Frame(3, 3));
        scoreTable.add(new Frame(2, 2));
        scoreTable.add(new Frame(1, 1));
        scoreTable.add(new Frame(2, 2));
        scoreTable.add(new Frame(3, 3));
        scoreTable.add(new Frame(4, 4));
        Line line = new Line(scoreTable);
        long result = 50;
        assertEquals(result, line.calculate());
    }
}