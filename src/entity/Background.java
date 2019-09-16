package entity;

import bases.SpriteUltis;
import bases.Vector2D;

import java.awt.*;
public class Background {
    Image image;
    Vector2D position;

    public Background(){
        this.image = SpriteUltis.loadImage("assets/images/background/0.png");
        this.position = new Vector2D(0, 600-3109);
    }

    /**
     * render image
     *
     * @param g
     */
    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

    /**
     * logic
     */
    public void run() {
        if (this.position.y<0){
            this.position.y++;
        }
        else if (this.position.y > 0 ){
            this.position.y = -2509;
        }
    }

}

