package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.setDirection(direction);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) { this.direction = direction; }

    public void execute(char command) {
        switch(command) {
            case 'L': rotateLeft(); break;
            case 'R': rotateRight(); break;
            case 'F': moveForward(); break;
        }
    }

    private void rotateLeft() {
        switch (direction) {
            case 'N': this.setDirection('W'); break;
            case 'W': this.setDirection('S'); break;
            case 'S': this.setDirection('E'); break;
            case 'E': this.setDirection('N'); break;
        }
    }

    private void rotateRight() {
        switch (direction) {
            case 'N': this.setDirection('E'); break;
            case 'W': this.setDirection('N'); break;
            case 'S': this.setDirection('W'); break;
            case 'E': this.setDirection('S'); break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N': moveUp(); break;
            case 'S': moveDown(); break;
            case 'W': moveLeft(); break;
            case 'E': moveRight(); break;
        }
    }

    private int moveUp() {
        return row--;
    }

    private int moveDown() {
        return row++;
    }

    private int moveRight() {
        return column++;
    }

    private int moveLeft() {
        return column--;
    }
}
