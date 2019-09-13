import java.security.Key;

public class KeyPressed {
    boolean upPressed;
    boolean downPressed;
    boolean rightPressed;
    boolean leftPressed;
    boolean shootPressed;
    private static final KeyPressed INSTANCE = new KeyPressed();

    private KeyPressed(){
        //chi co the khoi tao o day
        this.upPressed = false;
        this.downPressed = false;
        this.rightPressed = false;
        this.leftPressed = false;
        this.shootPressed = false;
    }

    public static KeyPressed getInstance(){
        //static ko this
        return INSTANCE;
    }
}
