package entities.enemy;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import entities.player.Player;
import renderer.ImageRenderer;

public class EnemyBossSpell extends GameObject{
    int spellDist = 3;

    public  EnemyBossSpell(){
        this.renderer = new ImageRenderer("assets/images/enemies/bullets/cyan.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 16,16);
    }

    @Override
    public void run() {
        this.deActiveIfNeeded();
        this.position.y+= spellDist;
        Player player = GameObject.checkCollider(this, Player.class);
        if (player != null ){
            System.out.println("dang chet");
            this.deActive();
        }
    }
    public void deActiveIfNeeded(){
        if (this.position.y >600| this.position.y<0 | this.position.x <0 | this.position.x>384){
            deActive();
        }
    }

    @Override
    public void reset() {
        super.reset();
    }

}
