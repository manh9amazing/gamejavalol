package entity;

import bases.SpriteUltis;
import bases.Vector2D;

import java.awt.*;

public class PlayerSpell {
    Vector2D position;
    Image image;

    public PlayerSpell(){
        this.image = SpriteUltis.loadImage("assets/images/player-spells/a/1.png");
        this.position = new Vector2D();
    }
    public void render(Graphics g) {
        g.drawImage(this.image,(int) this.position.x, (int) this.position.y, null);
    }
    public void run(){
        this.position.y -=5;
    }
}
