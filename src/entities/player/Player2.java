package entities.player;

import bases.*;
import renderer.Animation;
import renderer.ImageRenderer;
import scene.SceneManager;
import scene.gameOverScene.GameOverScene;

import javax.lang.model.element.AnnotationMirror;

public class Player2 extends GameObject {
    //gameobject(this)--> this se chi vao player va add vao Game object
    int count = 50;
    FrameCounter frameCounter;
    //    bases.Vector2D position = new Vector(0,0);
//    ArrayList<PlayerSpell> PlayerSpells;
//C2: Keypressed keyPressed;
    public Player2(){
        this.renderer = new Animation(10,
                SpriteUtils.loadImage("assets/images/players/straight/0.png"),
                SpriteUtils.loadImage("assets/images/players/straight/1.png"),
                SpriteUtils.loadImage("assets/images/players/straight/2.png"),
                SpriteUtils.loadImage("assets/images/players/straight/3.png"),
                SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        this.position = new Vector2D(100,100);
//       this.PlayerSpells = new ArrayList<>();
        this.boxCollider = new BoxCollider(this, 32, 48);
        frameCounter = new FrameCounter(20);
        this.velocity.set(0,0);
    }


    public void run() {
        float vx=0 , vy=0;
        if (KeyPressed.getInstance().wPressed){
            vy-=5;
//            this.position.y-=5;
        }
        if (KeyPressed.getInstance().sPressed){
            vy+=5;
//            this.position.y+=5;
        }
        if (KeyPressed.getInstance().dPressed){
            vx+=5;
//            this.position.x+=5;
        }
        if (KeyPressed.getInstance().aPressed){
            vx-=5;
//            this.position.x-=5;
        }
        if (KeyPressed.getInstance().enterPressed && frameCounter.expired){
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
