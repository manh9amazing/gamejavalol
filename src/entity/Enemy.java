package entity;

import bases.SpriteUltis;
import bases.Vector2D;

import java.awt.*;

public class Enemy {
    Vector2D position;
    Image image;

    public Enemy(){
        this.image = SpriteUltis.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position = new Vector2D((float) (Math.random()*384), 20);
    }
    public void render(Graphics g) {
        g.drawImage(this.image,(int) this.position.x, (int) this.position.y, null);
    }
    public void run(){
        this.position.y ++;
    }
}
