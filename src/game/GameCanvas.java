package game;

import bases.GameObject;
import bases.KeyPressed;
import entities.player.Player;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.welcomeScene.GameWelcomeScene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends JPanel {



    public GameCanvas(){
        SceneManager.signNewScene(new GameWelcomeScene());
        this.KeyListener();

    }
    private void KeyListener() {
        this.setFocusable(true);
        //co kha nang bat su kien
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed = true;
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
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().wPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyPressed.getInstance().aPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().sPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyPressed.getInstance().dPressed= true;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KeyPressed.getInstance().enterPressed= true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyPressed.getInstance().anyKeyPressed =false;
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
                if (e.getKeyCode() == KeyEvent.VK_W){
                    KeyPressed.getInstance().wPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    KeyPressed.getInstance().aPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    KeyPressed.getInstance().sPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    KeyPressed.getInstance().dPressed= false;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KeyPressed.getInstance().enterPressed= false;
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        int prtHP;
        g.setColor(Color.white);
        g.fillRect(0,0,700,600);
        g.setColor(Color.black);
        GameObject.renderALL(g);


    }
}
