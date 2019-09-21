package entities;
import bases.BoxCollider;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

public class Enemy extends GameObject {
    int isShooting = 0;
    int spellNum = 3;

    public Enemy(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position = new Vector2D((float) Math.random()*384, 0);
        this.boxCollider = new BoxCollider(this,28,28);
        //neu thay master: this --> this.position thi box se ko thay doi vi tri do qua moi lan run position se ko doi
        //boxCollider da lay thong tin cua enemy ke ca position
        //math.random() tao ra so ngau nhien tu 0.0-->1.0
        //be gay duong dan (spell) vi vua ban dan vua tien ve phia truoc
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
    private void castSpell() {
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

}
