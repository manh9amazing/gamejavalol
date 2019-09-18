package entities;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

public class EnemySpell extends GameObject {
    int spellDist = 2;
    double createAngle;

    public EnemySpell (double createAngle){
        this.createAngle = createAngle;
        this.image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
        this.position = new Vector2D();
    }

    public void run(){
        this.position.x -= spellDist*Math.cos(this.createAngle);
        this.position.y += spellDist*Math.sin(this.createAngle);
    }

}
