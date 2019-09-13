import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player {
    int x = 200;
    int y = 200;
    Image image;
//C2: Keypressed keyPressed;

    public Player(){
       this.image = SpriteUltis.loadImage("assets/images/players/straight/0.png");
       this.x = 200;
       this.y = 200;
    }

    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }

    public void run() {
        if (KeyPressed.getInstance().upPressed){
            this.y -=5;
        }
        if (KeyPressed.getInstance().downPressed){
            this.y +=5;
        }
        if (KeyPressed.getInstance().rightPressed){
            this.x +=5;
        }
        if (KeyPressed.getInstance().leftPressed){
            this.x -=5;
        }
        this.x = Ultis.clamp(this.x,0,340);
        this.y = Ultis.clamp(this.y,0,510);
    }



}
