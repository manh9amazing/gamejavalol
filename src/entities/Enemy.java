package entities;
import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;

public class Enemy extends GameObject {
    int isShooting = 0;
    int spellNum = 10;

    public Enemy(){
        this.image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        this.position = new Vector2D((float) Math.random()*384, 0);
        //math.random() tao ra so ngau nhien tu 0.0-->1.0
        //be gay duong dan (spell) vi vua ban dan vua tien ve phia truoc
    }
    public void run() {
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
            EnemySpell newSpell = new EnemySpell(radConvert);
            newSpell.position.x = this.position.x + 8;
            newSpell.position.y = this.position.y + 32;
        }
    }

}
