import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    //lay thuoc tinh Jframe - tinh ke thua
    public int cnt = 1;
    GameCanvas canvas = new GameCanvas();
    public GameWindow(){

//        this.setVisible(true);
        this.setResizable(false);
        //khong the nhan thu nho, tranh vo hinh anh
        this.setSize(384,600);

        this.setContentPane(this.canvas);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
    public void gameLoop(){
        while(true){
            this.canvas.run();
            this.canvas.repaint();
            //ve lai moi thu tren panel
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//C2:
//    public void gameLoop(){
//        long lastTime = 0;
//        while(true){
//            long currentTime = System.nanoTime();
//            if (currentTime - lastTime >= 17_000_000){
//                this.canvas.run();
//                this.canvas.repaint();
//                lastTime = currentTime;
//            }
//
//        }
//    }

}
