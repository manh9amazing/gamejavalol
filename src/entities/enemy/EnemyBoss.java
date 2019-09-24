package entities.enemy;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.Animation;

public class EnemyBoss extends GameObject {
    int isShooting = 0;
    public int HP = 3;
    public EnemyBoss(){
        this.renderer = new Animation(10, false,
                SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
        this.position = new Vector2D((float) Math.random()*384, 0);
        this.boxCollider = new BoxCollider(this,34,50);
    }

    public void run() {
        this.deActiveIfNeeded();
        this.position.y ++;
        if (isShooting ==20){
            this.castSpell();
            isShooting=0;
        }
        else{
            isShooting++;
        }
    }
    public void castSpell() {
        EnemyBossSpell newSpellBoss = GameObject.recycle(EnemyBossSpell.class);
        newSpellBoss.position.x = this.position.x + 8;
        newSpellBoss.position.y = this.position.y + 32;
    }

    public void deActiveIfNeeded(){
        if (this.position.y >600| this.position.y<0 | this.position.x <0 | this.position.x>384){
            deActive();
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        EnemyExplosion enemyExplosion = GameObject.recycle(EnemyExplosion.class);
        enemyExplosion.position.set(this.position);
    }


}