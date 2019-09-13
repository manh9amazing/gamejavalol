import java.awt.*;

public class Enemy {
    int x ;
    int y ;
    Image image;

    public Enemy(){
        this.image = SpriteUltis.loadImage("assets/images/enemies/level0/blue/0.png");
        this.x = (int) (Math.random()*384);
        this.y = 20;
    }
    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }
    public void run(){
        this.y ++;
    }
}
