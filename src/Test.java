import bases.Vector2D;

public class Test {
    public static void main(String[] args) {
        Vector2D position = new Vector2D(3,4);
        Vector2D newVec = position.add(2,5);
        System.out.println(position.x);
    }
}

