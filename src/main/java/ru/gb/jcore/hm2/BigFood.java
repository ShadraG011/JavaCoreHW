package ru.gb.jcore.hm2;

import java.util.Random;

public class BigFood extends Cell {
    private final Random random;
    private final Snake snake;
    private final Food food;
    private final Poison poison;

    public BigFood(Snake snake, Food food, Poison poison) {
        super(-1, -1, SnakeGame.CELL_SIZE, SnakeGame.BIG_FOOD_COLOR);
        this.food = food;
        this.poison = poison;
        random = new Random();
        this.snake = snake;
    }

    public void appear() {
        int x, y;
        do {
            x = random.nextInt(SnakeGame.CANVAS_WIDTH);
            y = random.nextInt(SnakeGame.CANVAS_HEIGHT);
        } while (snake.isInSnake(x, y) || food.isInFood(x, y) || poison.isInPoison(x, y));
        setXY(x, y);
    }

    public boolean isEaten() {
        return getX() == -1;
    }

    public void eat() {
        setXY(-1, -1);
    }

    public boolean isBigFood(int x, int y) {
        return (getX() == x && getY() == y);
    }
}
