package bases;

import entities.player.Player;
import renderer.Renderer;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

//add la bc staging cua git
public class GameObject extends  Buff{
    private static ArrayList<GameObject> gameObjects= new ArrayList<>();

    public static void add(GameObject gameObject){
        gameObjects.add(gameObject);
    }
    public static void clear() {
        gameObjects.clear();

    }
    public static void renderALL(Graphics g){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if( gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public static void runALL(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if(gameObject.isActive) {
                gameObject.run();
            }
        }
        System.out.println(gameObjects.size());
    }



    //Generics
    public static <T extends GameObject> T checkCollider(GameObject master, Class <T> cls ){
        for (int i = 0 ; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive && gameObject.getClass().equals(cls)){
                if (gameObject.boxCollider!= null){
                    if (master.boxCollider.collideWith(gameObject.boxCollider))  {
                        return (T) gameObject;
                        //enemy la gameObject nhung gameObject java ko bt la enemy hay ko
                    }
                }
            }
        }
        return null;
    }

    public static <E extends GameObject> E recycle(Class<E> cls){
            E gameObject = GameObject.findInactive(cls);
            if (gameObject != null){
                gameObject.reset();
                System.out.println("recycle");
//                System.out.println("hoi sinh"+ gameObject.getClass());
                return (E) gameObject;
            }
            try {
                    GameObject go = cls.getConstructor().newInstance();
//                    System.out.println("tao moi hoan toan" + go.getClass());
                    return (E) go;
                } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                    e.printStackTrace();
                    return null;
                    //co the sua doi
                }

    }

    private static <E extends GameObject> E findInactive(Class<E> cls) {
        for (int i = 0 ; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if (!gameObject.isActive && cls.isAssignableFrom(gameObject.getClass())){
                //cach 2 de so sanh cls va gameObject.getClass()
                 return (E) gameObject;
            }

        }
        return null;
    }

    public static <E extends GameObject> E findObject(Class<E>cls){
        for (int i = 0 ; i < gameObjects.size(); i++){
            GameObject gameObject = gameObjects.get(i);
            if (gameObject.isActive){
                return (E) gameObject;
            }
        }
        return null;
    }

//    public Renderer renderer;
//    public Vector2D position;
//    public Vector2D velocity;
//    public BoxCollider boxCollider;
//    public boolean isActive;
    public Vector2D anchor;

    public GameObject(){
        GameObject.add(this);
        this.position = new Vector2D(0,0);
        this.velocity = new Vector2D(0,0);
        this.anchor = new Vector2D(0.5f,0.5f);
        //0.5f cast kieu ve float, 0.5 la double;
        this.isActive = true;
        String s = 5 +"";
        //cast so 5 ve string
    }



    public void render(Graphics g) {
        int prtHP;
        if (renderer != null){
            renderer.render(g,this);
            g.drawString("dwsdasdasd",400,200);

        }
    }
    public void run(){
        this.position.addUp(this.velocity);
    }

    public void deActive(){
        this.isActive = false;
    }

    public void reset() {
        this.isActive = true;
        //va reset HP neu co
    }

}

