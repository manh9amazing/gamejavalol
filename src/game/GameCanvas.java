package game;

import bases.GameObject;
import bases.KeyPressed;
import entities.Background;
import entities.enemy.Enemy;
import entities.enemy.EnemyBoss;
import entities.enemy.EnemySpawner;
import entities.enemy.EnemyTwo;
import entities.player.Player;
import entities.player.SphereOne;
import entities.player.SphereTwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends JPanel {
    Background background;
    // de y xem co import nham file cua  java ko
    Player player;
    Enemy enemy;
    EnemyTwo enemyTwo;
    EnemyBoss enemyBoss;
    EnemySpawner enemySpawner;
    SphereOne sphereOne;
    SphereTwo sphereTwo;


    public GameCanvas(){
        this.background = new Background();
        this.enemy = new Enemy();
        this.enemyTwo = new EnemyTwo();
        this.enemyBoss = new EnemyBoss();
        this.player = new Player();
        this.sphereOne = new SphereOne();
        this.sphereTwo = new SphereTwo();
        enemySpawner = new EnemySpawner();
        this.KeyListener();

    }
    private void KeyListener() {
        this.setFocusable(true);
        //co kha nang bat su kien
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().shootPressed= true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    KeyPressed.getInstance().upPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    KeyPressed.getInstance().downPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    KeyPressed.getInstance().leftPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    KeyPressed.getInstance().rightPressed = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    KeyPressed.getInstance().shootPressed = false;
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        GameObject.renderALL(g);
    }
}