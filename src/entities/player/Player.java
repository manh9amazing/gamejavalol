package entities.player;
import bases.*;
import renderer.Animation;

public class Player extends GameObject {

    FrameCounter frameCounter;
    public Player(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/players/straight/0.png"),
                SpriteUtils.loadImage("assets/images/players/straight/1.png"),
                SpriteUtils.loadImage("assets/images/players/straight/2.png"),
                SpriteUtils.loadImage("assets/images/players/straight/3.png"),
                SpriteUtils.loadImage("assets/images/players/straight/4.png"),
                SpriteUtils.loadImage("assets/images/players/straight/5.png"),
                SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.position = new Vector2D(200,200);
        this.boxCollider = new BoxCollider(this, 32, 48);
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
        this.position.x = Utils.clamp(this.position.x,0,384-32);
        this.position.y = Utils.clamp(this.position.y,0,510);
        this.velocity.set(vx,vy);
        super.run();
    }

    public void castSpell() {
        PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
        newSpell.position.x = (int) this.position.x;
        newSpell.position.y = (int) this.position.y;
    }

}