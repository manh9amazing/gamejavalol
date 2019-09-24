package entities.player;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.enemy.Enemy;
import renderer.Animation;
import renderer.ImageRenderer;

import java.awt.*;

public class PlayerSpell extends GameObject {

    public PlayerSpell(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/player-spells/a/0.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/1.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/2.png"),
                SpriteUtils.loadImage("assets/images/player-spells/a/3.png"));
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 24,24);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void run(){
        this.deActiveIfNeeded();
        this.position.y -=5;
        Enemy enemy = GameObject.checkCollider(this, Enemy.class);
        if (enemy != null ){
//            System.out.println("dang va cham");
            enemy.deActive();
            //enemy.getHit--> deactive de dung cho enemy co mau
            this.deActive();
        }
        else{
//            System.out.println("ko phat hien");
        }

    }
    public void deActiveIfNeeded(){
        if (this.position.y >600 | this.position.y<0 | this.position.x <0 | this.position.x>384){
            deActive();
        }
    }
}
