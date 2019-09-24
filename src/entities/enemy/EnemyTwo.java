package entities.enemy;

import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.Animation;

public class EnemyTwo extends Enemy {
    public  EnemyTwo(){
        this.renderer = new Animation(10, false,
                SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/pink/1.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/pink/2.png"),
                SpriteUtils.loadImage("assets/images/enemies/level0/pink/3.png"));
        this.boxCollider = new BoxCollider(this,28,28);
    }
    @Override
    public void castSpell() {
        EnemyTwoSpell newSpellTwo = GameObject.recycle(EnemyTwoSpell.class);
        newSpellTwo.position.x = this.position.x + 8;
        newSpellTwo.position.y = this.position.y + 32;
    }


}