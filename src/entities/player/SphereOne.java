package entities.player;

import bases.*;
import renderer.Animation;

public class SphereOne extends GameObject{
    FrameCounter frameCounter;
    public  SphereOne(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png"));
        this.position = new Vector2D(232,200);
        this.boxCollider = new BoxCollider(this, 16, 16);
        frameCounter = new FrameCounter(20);
        this.velocity.set(0,0);
    }

    public void run() {
        float vx=0 , vy=0;
        if (KeyPressed.getInstance().upPressed){
            vy-=5;
        }
        if (KeyPressed.getInstance().downPressed){
            vy+=5;
        }
        if (KeyPressed.getInstance().rightPressed){
            vx+=5;
        }
        if (KeyPressed.getInstance().leftPressed){
            vx-=5;
        }
        if (KeyPressed.getInstance().shootPressed && frameCounter.expired){
            this.castSpell();
            frameCounter.reset();
        }
        else{
            frameCounter.run();
        }
        this.position.x = Utils.clamp(this.position.x,32,340+32+16);
        this.position.y = Utils.clamp(this.position.y,0,510);
        this.velocity.set(vx,vy);
        super.run();
    }

    private void castSpell() {
        SphereOneSpell newSphereOneSpell = GameObject.recycle(SphereOneSpell.class);
        newSphereOneSpell.position.x = (int) this.position.x;
        newSphereOneSpell.position.y = (int) this.position.y;
    }

}