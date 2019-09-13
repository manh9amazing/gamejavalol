import java.awt.*;

public class PlayerSpell {
    int x = 200;
    int y = 200;
    Image image;

    public PlayerSpell(){
        this.image = SpriteUltis.loadImage("assets/images/player-spells/a/1.png");
        this.x = x;
        this.y = y;
    }
    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
    }
    public void run(){
        this.y --;
    }
}
