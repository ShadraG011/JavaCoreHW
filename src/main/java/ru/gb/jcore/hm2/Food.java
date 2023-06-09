package ru.gb.jcore.hm2;

import java.util.Random;

public class Food extends Cell {
    private final Random random;
    private final Snake snake;

    public Food(Snake snake) {
        super(-1, -1, SnakeGame.CELL_SIZE, SnakeGame.FOOD_COLOR);
        random = new Random();
        this.snake = snake;
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(SnakeGame.CANVAS_WIDTH);
            y = random.nextInt(SnakeGame.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y));
        setXY(x, y);
    }

    public boolean isEaten() {
        return getX() == -1;
    }

    public void eat() {
        setXY(-1, -1);
    }

    public boolean isFood(int x, int y) {
        return (getX() == x && getY() == y);
    }

    public boolean isInFood(int x, int y) {
        return this.getX() == x && this.getY() == y;
    }
}
