package entities;

import bases.*;

import java.util.ArrayList;

public class Player extends GameObject {
    //gameobject(this)--> this se chi vao player va add vao Game object
    int count = 50;
    FrameCounter frameCounter;
//    bases.Vector2D position = new Vector(0,0);
//    ArrayList<PlayerSpell> PlayerSpells;
//C2: Keypressed keyPressed;
    public Player(){
       this.image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
       this.position = new Vector2D(200,200);
//       this.PlayerSpells = new ArrayList<>();
        this.boxCollider = new BoxCollider(this, 32, 48);
        frameCounter = new FrameCounter(20);
    }


    public void run() {
        if (KeyPressed.getInstance().upPressed){
            this.position.y -=5;
        }
        if (KeyPressed.getInstance().downPressed){
            this.position.y +=5;
        }
        if (KeyPressed.getInstance().rightPressed){
            this.position.x +=5;
        }
        if (KeyPressed.getInstance().leftPressed){
            this.position.x -=5;
        }
        if (KeyPressed.getInstance().shootPressed && frameCounter.expired){
            this.castSpell();
            frameCounter.reset();
        }
        else{
            frameCounter.run();
        }
        this.position.x = Utils.clamp(this.position.x,0,340);
        this.position.y = Utils.clamp(this.position.y,0,510);

    }

    /**
     * Khoi tao 1 vien dan moi
     * Gan gia tri x, y ban dau trung voi player
     * Add vao trong ArrayList PlayerSpells
     */

    private void castSpell() {
        PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
        newSpell.position.x = (int) this.position.x;
        newSpell.position.y = (int) this.position.y;
    }


}
