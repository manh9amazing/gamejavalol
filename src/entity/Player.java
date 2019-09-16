package entity;

import bases.KeyPressed;
import bases.SpriteUltis;
import bases.Ultis;
import bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;
    Image image;
    int coolDown = 50;
//    bases.Vector2D position = new Vector(0,0);
    ArrayList<PlayerSpell> PlayerSpells;

//C2: Keypressed keyPressed;

    public Player(){
       this.image = SpriteUltis.loadImage("assets/images/players/straight/0.png");
       this.position = new Vector2D(200,200);
       this.PlayerSpells = new ArrayList<>();

    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
        //chay tung spell
        for (int i = 0; i < this.PlayerSpells.size(); i++){
            PlayerSpell playerSpell = this.PlayerSpells.get(i);
            playerSpell.render(g);
        }
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
        if (KeyPressed.getInstance().shootPressed && coolDown >20){
            this.castSpell();
            coolDown = 0;
        }
        else{
            coolDown++;}
        this.position.x = Ultis.clamp( this.position.x,0,340);
        this.position.y = Ultis.clamp( this.position.y,0,510);
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
        newSpell.position.x = (int) this.position.x;
        newSpell.position.y = (int) this.position.y;
        PlayerSpells.add(newSpell);
    }


}
