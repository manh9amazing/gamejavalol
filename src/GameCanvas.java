import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;

    Image player;
    int PlayerX;
    int PlayerY;
    public GameCanvas(){

        try {
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
            this.player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //IO= in and out
        //copy relative path
        // vi neu dung copy path thi se bat dau tu o D cua may,neu cho nguoi khac choi game thi ko choi dc

        this.PlayerX = 176;
        this.PlayerY = 500;

        //bat su kien bam phim
        this.setFocusable(true);
        //co kha nang bat su kien
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W){
                    PlayerY-=5;
//                    repaint();
                    //ve lai moi thu tren panel
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
        g.drawImage(this.background, 0, 0, null);
        //truc x roi y
        g.drawImage(this.player, this.PlayerX, this.PlayerY, null);

    }

    public  void  run(){
        System.out.println("gameloop");;
    }
}
