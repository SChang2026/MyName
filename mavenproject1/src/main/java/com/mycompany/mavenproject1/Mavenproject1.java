/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author SChang2026
 */
public class Mavenproject1 {

    public static void main(String[] args) {
    JFrame frame = new JFrame("Space Shooter");
        GamePanel panel = new GamePanel();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panel.startGame();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Player player;
    private List<Bullet> bullets;
    private List<Enemy> enemies;

    public GamePanel() {
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });

        player = new Player();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        // Add some enemies
        for (int i = 0; i < 5; i++) {
            enemies.add(new Enemy(i * 100 + 50, 50));
        }

        timer = new Timer(16, this); // Roughly 60 FPS
    }

    public void startGame() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        for (Bullet bullet : bullets) {
            bullet.move();
        }

        for (Enemy enemy : enemies) {
            enemy.move();
        }

        // Check for collisions
        bullets.removeIf(bullet -> {
            if (bullet.y < 0) return true;
            for (Enemy enemy : enemies) {
                if (bullet.intersects(enemy)) {
                    enemies.remove(enemy);
                    return true;
                }
            }
            return false;
        });

  
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);
        for (Bullet bullet : bullets) {
            bullet.draw(g2d);
        }
        for (Enemy enemy : enemies) {
            enemy.draw(g2d);
        }
    }
}