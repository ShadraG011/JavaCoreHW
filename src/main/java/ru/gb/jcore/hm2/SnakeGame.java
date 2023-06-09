package ru.gb.jcore.hm2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JFrame {
    final String TITLE_OF_PROGRAM = "Classic Game Snake";
    final String GAME_OVER_MSG = "GAME OVER";
    final static int CELL_SIZE = 20;
    final static int CANVAS_WIDTH = 30;
    final static int CANVAS_HEIGHT = 25;
    final static Color SNAKE_COLOR = Color.darkGray;
    final static Color FOOD_COLOR = Color.green;
    final static Color POISON_COLOR = Color.red;
    final static Color BIG_FOOD_COLOR = Color.MAGENTA;
    final static int KEY_LEFT = 37;
    final static int KEY_UP = 38;
    final static int KEY_RIGHT = 39;
    final static int KEY_DOWN = 40;
    final static int KEY_UP_SPEED_W = 87;
    final static int KEY_UP_SPEED_S = 83;
    final int START_SNAKE_SIZE = 5;
    final int START_SNAKE_X = CANVAS_WIDTH / 2;
    final int START_SNAKE_Y = CANVAS_HEIGHT / 2;
    private int snakeDelay = 100;
    int snakeSize = 0;
    static boolean gameOver = false;
    Canvas canvas;
    Snake snake;
    Food food;
    Poison poison;
    BigFood bigFood;

    public static void main(String[] args) {
        new SnakeGame().start();
    }

    public SnakeGame() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        canvas = new Canvas();
        canvas.setBackground(Color.GRAY);
        canvas.setPreferredSize(new Dimension(CELL_SIZE * CANVAS_WIDTH, CELL_SIZE * CANVAS_HEIGHT));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                snake.setDirection(e.getKeyCode());
                upOrDownSpeed(e.getKeyCode());

            }
        });
        add(canvas);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void start() {
        snake = new Snake(START_SNAKE_X, START_SNAKE_Y, START_SNAKE_SIZE, KEY_RIGHT);
        food = new Food(snake);
        poison = new Poison(snake, food);
        bigFood = new BigFood(snake, food, poison);
        snake.setFood(food);
        snake.setBigFood(bigFood);
        while (!gameOver) {
            snake.move();
            if (snake.size() > snakeSize) {
                snakeSize = snake.size();
                setTitle(TITLE_OF_PROGRAM + ":" + snakeSize);
            }
            if (food.isEaten() || bigFood.isEaten()) {
                bigFood.appear();
                food.appear();
                poison.appear();
            }
            if (poison.isInPoison(snake.getSnakeHead()[0], snake.getSnakeHead()[1]) || snake.isInSnakeBody(snake.getSnakeHead()[0], snake.getSnakeHead()[1])) {
                gameOver = true;
                setTitle(GAME_OVER_MSG);
            }
            canvas.repaint();
            sleep(snakeDelay);
        }
    }

    private void upOrDownSpeed(int upOrDown) {
        if (upOrDown == KEY_UP_SPEED_W && snakeDelay > 10) {
            snakeDelay -= 10;
        } else if (upOrDown == KEY_UP_SPEED_S && snakeDelay < 200) {
            snakeDelay += 10;
        }
    }

    private void sleep(long ms) {    // method for suspending
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Canvas extends JPanel {    // class for rendering (drawing)
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            try {
                snake.paintSnake(g2D);
            } catch (NullPointerException e) {
                System.out.println(e.getStackTrace());
            }
            food.paintCell(g2D);
            poison.paintCell(g2D);
            bigFood.paintBig(g2D);

        }
    }
}
