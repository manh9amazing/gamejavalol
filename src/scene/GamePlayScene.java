package scene;

import bases.GameObject;
import entities.Background;
import entities.enemy.Enemy;
import entities.enemy.EnemySpawner;
import entities.player.Player;
import entities.player.Player2;

public class GamePlayScene extends Scene{

    // de y xem co import nham file cua  java ko
    @Override
    public void init() {
        Background background = new Background();
        Player player = GameObject.recycle(Player.class);
        Player2 player2 = GameObject.recycle(Player2.class);
        Enemy enemy = GameObject.recycle(Enemy.class);
        EnemySpawner enemySpawner = new EnemySpawner();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
