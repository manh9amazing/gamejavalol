import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        //graphic g nhu 1 cai but ve, dung method cua g de ve
//        g.drawRect(0,0,100,200);
        g.setColor(Color.black);
        g.fillRect(0,0,100,200);

    }
}
