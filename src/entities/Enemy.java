package entities;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

import java.awt.*;

public class Enemy extends GameObject {
    public Enemy(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position = new Vector2D((float) (Math.random()*384), 20);
    }
    @Override
    public void render(Graphics g) {
        super.render(g);
    }
    @Override
    public void run() {
        this.position.y ++;
    }
}
