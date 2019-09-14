public class Vector2D {
    float x;
    float y;
    public Vector2D(){
      this.x = 0;
      this.y = 0;
    }
    public Vector2D(float x , float y){
        this.x = x;
        this.y = y;
    }
    public void addUp(int a, int b) {
        this.x +=a;
        this.y +=b;
    }
    public Vector2D add(int a, int b){
        Vector2D newVector = new Vector2D(this.x + a , this.y + b);
        return newVector;
    }
    public void subtractBy(int a, int b) {
        this.x -=a;
        this.y -=b;
    }
    public Vector2D subtract(int a, int b){
        Vector2D newVector = new Vector2D(this.x - a , this.y - b);
        return newVector;
    }
    public void Multiply(int n){
        this.x = this.x * n;
        this.y = this.y * n;
    }
    public double Length(){
        float length = (float) Math.sqrt(x*x + y*y);
        return length;
    }
    public void Normalize(){
        float length = (float) this.Length();
        this.x = this.x/(length);
        this.y = this.y/(length);
    }
}
