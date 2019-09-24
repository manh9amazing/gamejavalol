package entities.enemy;
import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.Animation;
import renderer.ImageRenderer;

public class Enemy extends GameObject {
    int isShooting = 0;
    int spellNum = 3;

    public Enemy(){
        this.renderer = new Animation(10, false,
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/blue/3.png"));
        this.position = new Vector2D((float) Math.random()*384, 0);
        this.boxCollider = new BoxCollider(this,32,32);
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
        for (int i = 0 ; i < spellNum  ; i++){
            double tempAng = (180 / (spellNum-1)) * i;
            double radConvert = Math.toRadians(tempAng);
            EnemySpell newSpell = GameObject.recycle(EnemySpell.class);
            newSpell.createAngle = radConvert;
            newSpell.position.x = this.position.x + 8;
            newSpell.position.y = this.position.y + 32;
        }
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