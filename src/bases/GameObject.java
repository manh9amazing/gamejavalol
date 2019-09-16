package bases;

import java.awt.*;
import java.util.ArrayList;

//add la bc staging cua git
public class GameObject {
    private static ArrayList<GameObject> gameObjects= new ArrayList<>();

    public static void add(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public static void renderALL(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            gameObject.render(g);
        }
    }

    public static void runALL(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            gameObject.run();
        }
    }

    public Image image;
    public Vector2D position;

    public GameObject(){
        GameObject.add(this);
        this.position = new Vector2D(0,0);
    }
    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }
    public void run(){

    }
}

