package ru.gb.jcore.hm2;

import java.awt.*;

public class Cell {
    private int x, y;
    private int size;
    private Color color;

    public Cell(int x, int y, int size, Color color) {
        setXY(x, y);
        setSize(size);
        setColor(color);
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paintCell(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x * size, y * size, size, size);
    }
    public void paintBig(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x * size, y * size, size + 10, size + 10);

    }
}
