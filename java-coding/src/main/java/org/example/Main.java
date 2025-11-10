package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        String prev = "";
        for (String f : folder) {
            if (prev.isEmpty() || !f.startsWith(prev + "/")) {
                list.add(f);
                prev = "";
            }
        }
        return list;
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
//
//        List<String> res = sol.removeSubfolders(folder);
//        System.out.println(res); // Output: ["/a", "/c/d", "/c/f"]
//    }
//}


public class Main extends JPanel implements ActionListener, KeyListener {
    // Game constants
    private final int TILE_SIZE = 25;
    private final int GRID_WIDTH = 25;
    private final int GRID_HEIGHT = 25;
    private final int SCREEN_WIDTH = GRID_WIDTH * TILE_SIZE;
    private final int SCREEN_HEIGHT = GRID_HEIGHT * TILE_SIZE;

    // Snake and food
    private LinkedList<Point> snake;
    private Point food;
    private int dx = 1, dy = 0; // direction
    private boolean running = false;
    private Timer timer;
    private int score = 0;

    public Main() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        startGame();
    }

    public void startGame() {
        snake = new LinkedList<>();
        snake.add(new Point(GRID_WIDTH / 2, GRID_HEIGHT / 2));
        spawnFood();
        dx = 1; dy = 0;
        running = true;
        score = 0;

        timer = new Timer(120, this); // move every 120ms
        timer.start();
    }

    private void spawnFood() {
        Random rand = new Random();
        while (true) {
            Point p = new Point(rand.nextInt(GRID_WIDTH), rand.nextInt(GRID_HEIGHT));
            if (!snake.contains(p)) {
                food = p;
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) move();
        repaint();
    }

    private void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head.x + dx, head.y + dy);

        // wrap around edges
        if (newHead.x < 0) newHead.x = GRID_WIDTH - 1;
        if (newHead.y < 0) newHead.y = GRID_HEIGHT - 1;
        if (newHead.x >= GRID_WIDTH) newHead.x = 0;
        if (newHead.y >= GRID_HEIGHT) newHead.y = 0;

        // collision with itself
        if (snake.contains(newHead)) {
            running = false;
            timer.stop();
            return;
        }

        // add new head
        snake.addFirst(newHead);

        // food eaten?
        if (newHead.equals(food)) {
            score += 10;
            spawnFood();
        } else {
            snake.removeLast();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // grid (optional)
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i < SCREEN_WIDTH; i += TILE_SIZE)
            g.drawLine(i, 0, i, SCREEN_HEIGHT);
        for (int j = 0; j < SCREEN_HEIGHT; j += TILE_SIZE)
            g.drawLine(0, j, SCREEN_WIDTH, j);

        // draw food
        g.setColor(Color.RED);
        g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // draw snake
        g.setColor(Color.GREEN);
        for (Point p : snake)
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);

        // draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 20);

        // game over message
        if (!running) {
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", SCREEN_WIDTH / 2 - 100, SCREEN_HEIGHT / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to Restart", SCREEN_WIDTH / 2 - 110, SCREEN_HEIGHT / 2 + 40);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && dy == 0) { dx = 0; dy = -1; }
        else if (key == KeyEvent.VK_DOWN && dy == 0) { dx = 0; dy = 1; }
        else if (key == KeyEvent.VK_LEFT && dx == 0) { dx = -1; dy = 0; }
        else if (key == KeyEvent.VK_RIGHT && dx == 0) { dx = 1; dy = 0; }

        // Restart
        if (!running && key == KeyEvent.VK_SPACE) startGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game (Java)");
        Main game = new Main();
        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
