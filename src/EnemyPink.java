import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class EnemyPink {
    Image state;
    Image state0;
    Image state1;
    Image state2;
    Image state3;
    long lastTime = 0;
    boolean canRun = true;


    int x = 340;
    int y = 0;

    int cntState = 0;

    public EnemyPink(){
        this.state0 = SpriteUltis.loadImage("assets/images/enemies/level0/pink/0.png");
        this.state1 = SpriteUltis.loadImage("assets/images/enemies/level0/pink/1.png");
        this.state2 = SpriteUltis.loadImage("assets/images/enemies/level0/pink/2.png");
        this.state3 = SpriteUltis.loadImage("assets/images/enemies/level0/pink/3.png");
    }
    public void render(Graphics g) {
        g.drawImage(this.state, x, y, null);
    }
    public void clamp(){
        if (this.x <0){
            this. x = 0;
        }
        if (this.x >340){
            this.x = 340;
        }
        if (this.y <0){
            this.y = 0;
        }
        if (this.y >530 ){
            this.y = 530;
        }
    }
    public void decideXY(){
         if (canRun) {
             Random rand2 = new Random();
             int choiceXY = rand2.nextInt(2);
             int choiceDI = rand2.nextInt(2);
             if (choiceXY == 0) {
                 if (choiceDI == 0) {
                     this.x -= 5;
                 }
                 if (choiceDI == 1) {
                     this.x += 5;
                 }
             }
             if (choiceXY == 1) {
                 if (choiceDI == 0) {
                     this.y -= 5;
                 }
                 if (choiceDI == 1) {
                     this.y += 5;
                 }
             }
             this.clamp();
             canRun = false;
            }
            System.out.println("lol");
        }
    public void decideState(){
        if (cntState ==0){
            this.state = state0;
        }
        if (cntState ==25){
            this.state = state1;
        }
        if (cntState ==50){
            this.state = state2;
        }
        if (cntState ==75){
            this.state = state3;
        }
    }
    public void run(){
        this.decideState();
        this.resetTest();
        this.decideXY();
        if (cntState >= 75){
            cntState =0;
        }
        else{
            cntState++;
        }
    }
    public void resetTest(){
        long currentTime = System.nanoTime();
        if (currentTime - lastTime >= 17_000_000*6){
            canRun = true;
            System.out.println("ok");
            lastTime = currentTime;
        }
    }
}

