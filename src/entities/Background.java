package entities;

import bases.GameObject;
import bases.SpriteUtils;
import bases.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;
public class Background extends GameObject {

    public Background(){
        this.renderer = new ImageRenderer("assets/images/background/0.png");
        this.position = new Vector2D(0, 600-3109);
        //ko can khai bao do da co o game object neu ghi lai thi tuong duong viec ghi de
    }

    @Override
    //bao loi khi ko ghi de vd: chuyen render(int x) --> viet ham moi chu ko con la thua ke
    public void render(Graphics g) {
        super.render(g);
        //thua ke, viet lai cua cha

    }
    /**
     * logic
     */
    @Override
    public void run() {
        if (this.position.y<0){
            this.position.y++;
        }
        else if (this.position.y > 0 ){
            this.position.y = -2509;
        }
    }
}

