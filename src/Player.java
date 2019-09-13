import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Player {
    int x = 200;
    int y = 200;
    Image image;
    int coolDown = 50;
//    Vector2D position = new Vector(0,0);
    ArrayList<PlayerSpell> PlayerSpells;

//C2: Keypressed keyPressed;

    public Player(){
       this.image = SpriteUltis.loadImage("assets/images/players/straight/0.png");
       this.x = 200;
       this.y = 200;
       this.PlayerSpells = new ArrayList<>();

    }

    public void render(Graphics g) {
        g.drawImage(this.image, x, y, null);
        //chay tung spell
        for (int i = 0; i < this.PlayerSpells.size(); i++){
            PlayerSpell playerSpell = this.PlayerSpells.get(i);
            playerSpell.render(g);
        }
    }

    public void run() {
        if (KeyPressed.getInstance().upPressed){
            this.y -=5;
        }
        if (KeyPressed.getInstance().downPressed){
            this.y +=5;
        }
        if (KeyPressed.getInstance().rightPressed){
            this.x +=5;
        }
        if (KeyPressed.getInstance().leftPressed){
            this.x -=5;
        }
        if (KeyPressed.getInstance().shootPressed && coolDown >20){
            this.castSpell();
            coolDown = 0;
        }
        else{
            coolDown++;}
        this.x = Ultis.clamp(this.x,0,340);
        this.y = Ultis.clamp(this.y,0,510);
        for (int i = 0; i < this.PlayerSpells.size(); i++){
            PlayerSpell playerSpell = this.PlayerSpells.get(i);
            playerSpell.run();
        }

    }

    /**
     * Khoi tao 1 vien dan moi
     * Gan gia tri x, y ban dau trung voi player
     * Add vao trong ArrayList PlayerSpells
     */

    private void castSpell() {
        PlayerSpell newSpell = new PlayerSpell();
        newSpell.x = this.x;
        newSpell.y = this.y;
        PlayerSpells.add(newSpell);
    }


}
