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
            newEnemy.resetPositionForEnemy();
            frameCounter.reset();
        }
        else{frameCounter.run();}
    }
}