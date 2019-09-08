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

    Image background;
    Image blueState;
    Image pinkState;

    Image blueState0;
    Image blueState1;
    Image blueState2;
    Image blueState3;

    Image pinkState0;
    Image pinkState1;
    Image pinkState2;
    Image pinkState3;

    Image player;

    int PlayerX;
    int PlayerY;

    int enemyBlackX;
    int enemyBlackY;

    int enemyBlueX = 0;
    int enemyBlueY = 0;

    int enemyPinkX = 340;
    int enemyPinkY= 0 ;

    public int scroll;
    int Y_posi;
    boolean end = false;

    int cntState = 0;

//    public BufferedImage buf_img;
    public GameCanvas(){

        try {
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
//            this.buf_img = ImageIO.read(new File("assets/images/background/0.png"));
//            this.buf_img = buf_img.getSubimage(0,0 ,384 ,600);
            this.player = ImageIO.read(new File("assets/images/players/straight/0.png"));

            this.blueState0 = ImageIO.read(new File("assets/images/enemies/level0/blue/0.png"));
            this.blueState1 = ImageIO.read(new File("assets/images/enemies/level0/blue/1.png"));
            this.blueState2 = ImageIO.read(new File("assets/images/enemies/level0/blue/2.png"));
            this.blueState3 = ImageIO.read(new File("assets/images/enemies/level0/blue/3.png"));

            this.pinkState0 = ImageIO.read(new File("assets/images/enemies/level0/pink/0.png"));
            this.pinkState1 = ImageIO.read(new File("assets/images/enemies/level0/pink/1.png"));
            this.pinkState2 = ImageIO.read(new File("assets/images/enemies/level0/pink/2.png"));
            this.pinkState3 = ImageIO.read(new File("assets/images/enemies/level0/pink/3.png"));

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
        Y_posi = -2509 + scroll;
        this.infiniteRun();
        if (end == false) {
            g.drawImage(this.background, 0, Y_posi, null);
        }
        //truc x roi y
        g.drawImage(this.player, PlayerX, PlayerY, null);

        this.enemyBlueRun();
        g.drawImage(blueState, enemyBlueX, enemyBlueY, null);

        this.enemyPinkRun();
        g.drawImage(pinkState, enemyPinkX, enemyPinkY, null);

    }

    public void oneRun(){
        if (Y_posi>0){
            end = true;
        }
    }
    public void infiniteRun(){
        if (Y_posi>0){
            scroll = 0;
        }
    }

    public  void  run() {
//        System.out.println(scroll);
        scroll+=10;
        cntState+=1;
        this.stateClamp();
        System.out.println(cntState);
    }

    public void stateClamp(){
        if (cntState>15){
            cntState = 0;
        }
    }

    public void enemyBlueRun(){
        this.enemyBlueState();
        this.enemyBlueXY();
    }
    public void enemyBlueClamp(){
        if (enemyBlueX <0){
            enemyBlueX = 0;
        }
        if (enemyBlueX >340){
            enemyBlueX = 340;
        }
        if (enemyBlueY <0){
            enemyBlueY = 0;
        }
        if (enemyBlueY >530 ){
            enemyBlueY = 530;
        }
    }
    public void enemyBlueXY(){
        Random rand2 = new Random();
        int choiceXY = rand2.nextInt(2);
        int choiceDI = rand2.nextInt(2);
        if (choiceXY==0){
            if(choiceDI==0){
                enemyBlueX-=5;
            }
            if(choiceDI==1){
                enemyBlueX+=5;
            }
        }
        if (choiceXY==1){
            if(choiceDI==0){
                enemyBlueY-=5;
            }
            if(choiceDI==1){
                enemyBlueY+=5;
            }
        }
        this.enemyBlueClamp();
    }
    public void enemyBlueState(){
        if (cntState ==0){
            blueState = blueState0;
        }
        if (cntState ==5){
            blueState = blueState1;
        }
        if (cntState ==10){
            blueState = blueState2;
        }
        if (cntState ==15){
            blueState = blueState3;
        }

    }

    public void enemyPinkRun(){
        this.enemyPinkState();
        this.enemyPinkXY();
    }
    public void enemyPinkClamp(){
        if (enemyPinkX <0){
            enemyPinkX = 0;
        }
        if (enemyPinkX >340){
            enemyPinkX = 340;
        }
        if (enemyPinkY <0){
            enemyPinkY = 0;
        }
        if (enemyPinkY >530 ){
            enemyPinkY = 530;
        }
    }
    public void enemyPinkXY(){
        Random rand2 = new Random();
        int choiceXY = rand2.nextInt(2);
        int choiceDI = rand2.nextInt(2);
        if (choiceXY==0){
            if(choiceDI==0){
                enemyPinkX-=5;
            }
            if(choiceDI==1){
                enemyPinkX+=5;
            }
        }
        if (choiceXY==1){
            if(choiceDI==0){
                enemyPinkY-=5;
            }
            if(choiceDI==1){
                enemyPinkY+=5;
            }
        }
        this.enemyPinkClamp();
    }
    public void enemyPinkState(){
        if (cntState ==0){
            pinkState = pinkState0;
        }
        if (cntState ==5){
            pinkState = pinkState1;
        }
        if (cntState ==10){
            pinkState = pinkState2;
        }
        if (cntState ==15){
            pinkState = pinkState3;
        }
    }

}
