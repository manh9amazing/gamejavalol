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

public class GameCanvas extends JPanel {

    Image background;

    Image player;
    int PlayerX;
    int PlayerY;


//    int X;
//    int Y;
    public int scroll;

    public BufferedImage buf_img;
    public GameCanvas(){

        try {
//            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.buf_img = ImageIO.read(new File("assets/images/background/0.png"));
            this.buf_img = buf_img.getSubimage(0,(0 + scroll),384 ,600);
            this.player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //IO= in and out
        //copy relative path
        // vi neu dung copy path thi se bat dau tu o D cua may,neu cho nguoi khac choi game thi ko choi dc
        //bat su kien bam phim

        this.PlayerX = 200;
        this.PlayerY = 200;

        this.setFocusable(true);
        //co kha nang bat su kien


        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    PlayerY-=5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    PlayerY+=5;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    PlayerX-=5;
            }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    PlayerX+=5;
                }
                this.clampPlayer();
            }

            public void  clampPlayer(){

                if (PlayerX > 340){
                    PlayerX = 340;
                }
                if (PlayerX < 0){
                    PlayerX = 0;
                }
                if (PlayerY > 510){
                    PlayerY = 510;
                }
                if (PlayerY < 0){
                    PlayerY = 0;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        //graphic g nhu 1 cai but ve, dung method cua g de ve
//        g.drawRect(0,0,100,200);
        g.setColor(Color.black);
//        g.fillRect(0,0,100,200);

        g.drawImage(this.buf_img, 0, 0, null);
        //truc x roi y
        g.drawImage(this.player, this.PlayerX, this.PlayerY, null);

    }


    public void getResource(){

    }

    public  void  run() {
        System.out.println(scroll);
        this.repaint();
        scroll+=1000;
    }
}
