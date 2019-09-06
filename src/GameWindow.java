import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends JFrame {
    //lay thuoc tinh Jframe - tinh ke thua
    GameCanvas canvas = new GameCanvas();
    public GameWindow(){
//        this.setVisible(true);
        this.setResizable(false);
        //khong the nhan thu nho, tranh vo hinh anh
        this.setSize(600,600);

        this.setContentPane(this.canvas);
        this.setVisible(true);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {

            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
                System.out.println("window closing");
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {

            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {

            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {

            }
        });
    }
}
