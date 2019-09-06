import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background;
    Image char1;
    public GameCanvas(){
        try {
            this.background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //IO= in and out
        //copy relative path
        // vi neu dung copy path thi se bat dau tu o D cua may,neu cho nguoi khac choi game thi ko choi dc
    }
    @Override
    protected void paintComponent(Graphics g) {
        //graphic g nhu 1 cai but ve, dung method cua g de ve
//        g.drawRect(0,0,100,200);
        g.setColor(Color.black);
        g.fillRect(0,0,100,200);
        g.drawImage(this.background, 0, 0, null);

    }
}
