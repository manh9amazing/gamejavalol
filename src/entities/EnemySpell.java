package entities;
import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

public class EnemySpell extends GameObject {
    int spellDist = 2;
    double createAngle;

    public EnemySpell (){
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position = new Vector2D();
        this.boxCollider = new BoxCollider(this, 16,16);
    }

    public void run(){
        this.deActiveIfNeeded();
        this.position.x -= spellDist*Math.cos(this.createAngle);
        this.position.y += spellDist*Math.sin(this.createAngle);
        Player player = GameObject.checkCollider(this, Player.class);
        if (player != null ){
            System.out.println("dang chet");
//            player.deActive();
            //enemy.getHit--> deactive de dung cho enemy co mau
            this.deActive();
        }

    }

    public void deActiveIfNeeded(){
        if (this.position.y >600| this.position.y<0 | this.position.x <0 | this.position.x>384){
            deActive();
        }
    }

}