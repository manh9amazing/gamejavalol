import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameCanvas extends JPanel {
    Background background;
    // de y xem co import nham file cua  java ko
    Player player;
    Enemy enemy;



    public GameCanvas(){
        this.enemy = new Enemy();
        this.background = new Background();
        this.player = new Player();


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
        this.background.render(g);
        this.player.render(g);
        this.enemy.render(g);
    }
    public  void  run() {
       this.background.run();
       this.player.run();
       this.enemy.run();
    }
}
