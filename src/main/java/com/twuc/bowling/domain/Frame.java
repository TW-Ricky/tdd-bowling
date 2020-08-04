package com.twuc.bowling.domain;

public class Frame {
    private Integer firstThrow;
    private Integer secondThrow;

    public Frame() {
    }

    public Frame(Integer firstThrow, Integer secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "firstThrow=" + firstThrow +
                ", secondThrow=" + secondThrow +
                '}';
    }

    public Integer getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(Integer firstThrow) {
        this.firstThrow = firstThrow;
    }

    public Integer getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(Integer secondThrow) {
        this.secondThrow = secondThrow;
    }
}
