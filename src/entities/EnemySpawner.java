package entities;

import bases.BoxCollider;
import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemySpawner extends GameObject {
    FrameCounter frameCounter;
    public EnemySpawner(){
        frameCounter = new FrameCounter(200);
    }
    @Override
    public void run() {
        if (frameCounter.expired){
            Enemy newEnemy = GameObject.recycle(Enemy.class);
//            newEnemy.position = new Vector2D((float) (Math.random()*384), 0);
//            newEnemy.boxCollider = new BoxCollider(newEnemy,28,28);
            newEnemy.position.x = (float) (Math.random()*384);
            newEnemy.position.y = 0;
            frameCounter.reset();
        }
        else{frameCounter.run();}
    }
}
