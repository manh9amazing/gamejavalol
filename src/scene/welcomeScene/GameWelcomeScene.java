package scene.welcomeScene;

import bases.GameObject;
import entities.Background;
import scene.Scene;

public class GameWelcomeScene extends Scene {
    @Override
    public void init() {
        BackgroundWelcome backgroundWelcome = new BackgroundWelcome();
    }

    @Override
    public void clear() {
        GameObject.clear();
    }
}
