package entities;

import bases.GameObject;
import bases.SpriteUltis;
import bases.Vector2D;

import java.awt.*;

public class PlayerSpell extends GameObject {

    public PlayerSpell(){
        this.image = SpriteUltis.loadImage("assets/images/player-spells/a/1.png");
        this.position = new Vector2D();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void run(){
        this.position.y -=5;
    }
}
