package entities.player;

import bases.*;
import renderer.Animation;
import renderer.ImageRenderer;
import scene.SceneManager;
import scene.gameOverScene.GameOverScene;

import javax.lang.model.element.AnnotationMirror;
import java.awt.*;

public class Player extends GameObject {
    //gameobject(this)--> this se chi vao player va add vao Game object
    int count = 50;
    FrameCounter frameCounter;
//    bases.Vector2D position = new Vector(0,0);
//    ArrayList<PlayerSpell> PlayerSpells;
//C2: Keypressed keyPressed;
    public Player(){
       this.renderer = new Animation(10,
               SpriteUtils.loadImage("assets/images/players/straight/0.png"),
               SpriteUtils.loadImage("assets/images/players/straight/1.png"),
               SpriteUtils.loadImage("assets/images/players/straight/2.png"),
               SpriteUtils.loadImage("assets/images/players/straight/3.png"),
               SpriteUtils.loadImage("assets/images/players/straight/4.png"));
       this.position = new Vector2D(200,200);
//       this.PlayerSpells = new ArrayList<>();
        this.boxCollider = new BoxCollider(this, 32, 48);
        frameCounter = new FrameCounter(20);
        this.velocity.set(0,0);
        this.HP = 25;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawString(Integer.toString(HP),400,250);
    }

    public void run() {
        float vx=0 , vy=0;
        if (KeyPressed.getInstance().upPressed){
            vy-=5;
//            this.position.y-=5;
        }
        if (KeyPressed.getInstance().downPressed){
            vy+=5;
//            this.position.y+=5;

        }
        if (KeyPressed.getInstance().rightPressed){
            vx+=5;
//            this.position.x+=5;
            this.renderer = new Animation(10,
                    SpriteUtils.loadImage("assets/images/players/right/0.png"),
                    SpriteUtils.loadImage("assets/images/players/right/1.png"),
                    SpriteUtils.loadImage("assets/images/players/right/2.png"),
                    SpriteUtils.loadImage("assets/images/players/right/3.png"),
                    SpriteUtils.loadImage("assets/images/players/right/4.png"),
                    SpriteUtils.loadImage("assets/images/players/right/5.png"));
        }
        if (KeyPressed.getInstance().leftPressed){
            vx-=5;
//            this.position.x-=5;
            this.renderer = new Animation(10,
                    SpriteUtils.loadImage("assets/images/players/left/0.png"),
                    SpriteUtils.loadImage("assets/images/players/left/1.png"),
                    SpriteUtils.loadImage("assets/images/players/left/2.png"),
                    SpriteUtils.loadImage("assets/images/players/left/3.png"),
                    SpriteUtils.loadImage("assets/images/players/left/4.png"),
                    SpriteUtils.loadImage("assets/images/players/left/5.png"));
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
        this.velocity.set(vx,vy);
        super.run();
//        this.Poisoned();
        this.Healing(20);
//        this.Healing(20, true);
        this.Healing(40);
    }

    /**
     * Khoi tao 1 vien dan moi
     * Gan gia tri x, y ban dau trung voi player
     * Add vao trong ArrayList PlayerSpells
     */

//    private void castSpell() {
//        PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
//        newSpell.position.x = (int) this.position.x;
//        newSpell.position.y = (int) this.position.y;
//    }

    private void castSpell() {
        int numberB = 9;
        double startAngle = -120;
        double endAngle = -60;
        double step = (endAngle - startAngle)/(numberB - 1);

        for (int i = 0; i < numberB; i++) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(this.position.x, this.position.y);
            newSpell.velocity.setAngle(Math.toRadians(startAngle + (step * i)));
        }
    }

    @Override
    public void deActive() {
        super.deActive();
        SceneManager.signNewScene(new GameOverScene());
    }
}
