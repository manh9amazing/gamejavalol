package entities.player;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import entities.enemy.Enemy;
import entities.enemy.EnemyBoss;
import entities.enemy.EnemyTwo;
import renderer.Animation;

import java.awt.*;

public class SphereOneSpell extends GameObject {

    public SphereOneSpell(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/sphere-spells/0.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/1.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/2.png"),
                SpriteUtils.loadImage("assets/images/sphere-spells/3.png"));
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
            enemy.deActive();
            this.deActive();
        }
        EnemyTwo enemyTwo = GameObject.checkCollider(this, EnemyTwo.class);
        if (enemyTwo != null ){
            enemyTwo.deActive();
            this.deActive();
        }
        EnemyBoss enemyBoss = GameObject.checkCollider(this, EnemyBoss.class);
        if (enemyBoss != null ){
            enemyBoss.deActive();
            this.deActive();
        }


    }
    public void deActiveIfNeeded(){
        if (this.position.y >600 | this.position.y<0 | this.position.x <0 | this.position.x>384){
            deActive();
        }
    }
}