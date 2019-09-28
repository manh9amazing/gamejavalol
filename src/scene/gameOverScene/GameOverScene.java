package scene.gameOverScene;

import bases.GameObject;
import entities.Background;
import scene.Scene;

public class GameOverScene extends Scene {

    @Override
    public void init() {
        BackgroundGameOver backgroundGameOver = new BackgroundGameOver();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}