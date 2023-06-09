package ru.gb.jcore.hm2;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private final LinkedList<Cell> snake = new LinkedList<>();
    private int direction;
    private Food food;

    private BigFood bigFood;


    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            snake.add(new Cell(x - i, y, SnakeGame.CELL_SIZE, SnakeGame.SNAKE_COLOR));
        }
        this.direction = direction;
    }

    public int size() {
        return snake.size();
    }

    public void setDirection(int direction) {
        if ((direction >= SnakeGame.KEY_LEFT) && (direction <= SnakeGame.KEY_DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public void move() {
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        switch (direction) {
            case SnakeGame.KEY_LEFT -> {
                x--;
                if (x < 0)
                    x = SnakeGame.CANVAS_WIDTH - 1;
            }
            case SnakeGame.KEY_RIGHT -> {
                x++;
                if (x == SnakeGame.CANVAS_WIDTH)
                    x = 0;
            }
            case SnakeGame.KEY_UP -> {
                y--;
                if (y < 0)
                    y = SnakeGame.CANVAS_HEIGHT - 1;
            }
            case SnakeGame.KEY_DOWN -> {
                y++;
                if (y == SnakeGame.CANVAS_HEIGHT)
                    y = 0;
            }
        }

        snake.addFirst(new Cell(x, y, SnakeGame.CELL_SIZE, SnakeGame.SNAKE_COLOR)); // new head of snake
        if (food.isFood(x, y)) {
            food.eat();
        } else if (bigFood.isBigFood(x, y)) {
            bigFood.eat();
            snake.addFirst(new Cell(x, y, SnakeGame.CELL_SIZE, SnakeGame.SNAKE_COLOR));
        } else {
            snake.removeLast();
        }
    }

    public void paintSnake(Graphics2D g) {
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).paintCell(g);
        }
    }

    public boolean isInSnakeBody(int x, int y) {
        for (int i = 3; i < snake.size(); i++) {
            if (snake.get(i).getX() == x && snake.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isInSnake(int x, int y) {
        for (Cell cell : snake) {
            if ((cell.getX() == x) && (cell.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setBigFood(BigFood bigFood) {
        this.bigFood = bigFood;
    }

    public int[] getSnakeHead() {
        int x = snake.getFirst().getX();
        int y = snake.getFirst().getY();
        return new int[]{x, y};
    }
}
