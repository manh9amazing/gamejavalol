import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Background {
    Image image;
    int x = 0;
    int y = -2509;

    public Background(){
        this.image = SpriteUltis.loadImage("assets/images/background/0.png");
        this.x = 0;
        this.y = 600-3109;
    }

    /**
     * render image
     *
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    /**
     * logic
     */
    public void run() {
        if (this.y<0){
            this.y++;
        }
        else if (this.y > 0 ){
            this.y = -2509;
        }
    }

}

