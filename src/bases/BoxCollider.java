package bases;

public class BoxCollider {
    Vector2D position;
    float width, height;

    public BoxCollider(GameObject master, float width, float height) {
        //lay thong tin cua phan tu chua boxCollider
        this.position = master.position;
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

    //ToDo: can lam gi
    public boolean collideWith(BoxCollider other){
        return  this.right() >= other.left()&&
                this.left() <= other.right() &&
                this.bot ()>= other.top()&&
                this.top()<= other.bot();

    }
}
