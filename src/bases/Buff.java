package bases;

import renderer.Renderer;

public class Buff {
    public int HP;
    int time = 0;
    public boolean toggleOn = false;
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public BoxCollider boxCollider;
    public boolean isActive;
    public boolean done;
    FrameCounter frameCounter = new FrameCounter(3);

    public Buff(){
        this.toggleOn = true;
    }
    public void Healing(int limit){
        int l = limit;
        if (l > 0) {
            if (frameCounter.expired) {
                this.HP ++;
                l--;
                System.out.println("limit" + l);
                this.frameCounter.reset();
            }
            else {
                this.frameCounter.
                        run();
            }
        }
//        if (time>=limit){
//            time = 0;
//            endHealing = true;
//        }
//        if (time<limit &&  !endHealing){
//            time++;
//            this.HP++;
//        }
    }
    public  void Poisoned(int limit, boolean endPoison) {
        if (time >= limit) {
            time = 0;
            endPoison = true;
        }
        if (time < limit && !endPoison) {
            time++;
            this.HP--;
        }
    }
    public void resetTime (){
        this.time = 0;
    }
}
