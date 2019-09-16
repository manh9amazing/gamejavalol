package bases;

public class BoxCollider {
    Vector2D position;
    float width, height;

    public BoxCollider(Vector2D position, float width, float height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public float top(){
        return this.position.y;
    }
    public float bot(){
        return this.position.y + this.height;
    }
    public float left(){
        return this.position.x;
    }
    public float right(){
        return this.position.x + this.width;
    }

    public static void main(String[] args) {
        BoxCollider box1 = new BoxCollider(new Vector2D(0,0),5,5);
        BoxCollider box2 = new BoxCollider(new Vector2D(1,1),5,5);
        System.out.println(box1.collideWith(box2));
    }
    //ToDo: can lam gi
    public boolean collideWith(BoxCollider other){
        return  this.right() >= other.left()&&
                this.left() <= other.right() &&
                this.bot ()>= other.top()&&
                this.top()<= other.bot();

    }
}
