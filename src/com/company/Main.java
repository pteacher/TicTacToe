package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main extends JFrame {
    static final int WINDOW_WIDTH = 512;
    static final int WINDOW_HEIGHT = 512;
    static final int FIELD_SIZE = 10;

    public Main() {
        setName("TicTacToe Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
    }

    public static void main(String[] args) {
        Main m = new Main();
        Graphics g = m.getGraphics();

        Scanner scanner = new Scanner(System.in);
        boolean turn = true;

        while (true) {
            if (turn) {
                drawNolik(scanner.nextInt(), scanner.nextInt(), g);
            }
            else {
                drawKrestik(scanner.nextInt(), scanner.nextInt(), g);
            }
            turn = !turn;
        }

    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i * WINDOW_HEIGHT / FIELD_SIZE ,
                       WINDOW_WIDTH,
                    i * WINDOW_HEIGHT / FIELD_SIZE);
        }
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(i * WINDOW_WIDTH / FIELD_SIZE, 0,
                    i * WINDOW_WIDTH / FIELD_SIZE ,
                    i * WINDOW_HEIGHT);
        }
    }

    public static void drawKrestik(int x, int y, Graphics g) {
        g.drawLine(x * (WINDOW_WIDTH / FIELD_SIZE),
                   y * (WINDOW_HEIGHT / FIELD_SIZE),
                (x + 1) * (WINDOW_WIDTH / FIELD_SIZE),
                (y + 1) * (WINDOW_HEIGHT / FIELD_SIZE));

        g.drawLine((x + 1) * (WINDOW_WIDTH / FIELD_SIZE),
                y * (WINDOW_HEIGHT / FIELD_SIZE),
                x * (WINDOW_WIDTH / FIELD_SIZE),
                (y + 1) * (WINDOW_HEIGHT / FIELD_SIZE));
    }

    public static void drawNolik(int x, int y, Graphics g) {
        g.drawOval(x * (WINDOW_WIDTH / FIELD_SIZE),
                   y * (WINDOW_HEIGHT / FIELD_SIZE),
                (int) (WINDOW_WIDTH / FIELD_SIZE * 1.0),
                (int) (WINDOW_HEIGHT / FIELD_SIZE * 1.0));
    }
}
