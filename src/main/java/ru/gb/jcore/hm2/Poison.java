package ru.gb.jcore.hm2;

import java.util.Random;

public class Poison extends Cell {
    private final Random random;
    private final Snake snake;
    private final Food food;

    public Poison(Snake snake, Food food) {
        super(-1, -1, SnakeGame.CELL_SIZE, SnakeGame.POISON_COLOR);
        this.food = food;
        random = new Random();
        this.snake = snake;
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(SnakeGame.CANVAS_WIDTH);
            y = random.nextInt(SnakeGame.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y) || food.isInFood(x, y));
        setXY(x, y);
    }

    public boolean isInPoison(int x, int y) {
        return this.getX() == x && this.getY() == y;
    }

}
