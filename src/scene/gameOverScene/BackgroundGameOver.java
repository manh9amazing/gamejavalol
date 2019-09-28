package scene.gameOverScene;

import bases.FrameCounter;
import bases.GameObject;
import bases.KeyPressed;
import entities.player.Player;
import renderer.ImageRenderer;
import scene.GamePlayScene;
import scene.SceneManager;
import scene.welcomeScene.GameWelcomeScene;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        this.renderer = new ImageRenderer("assets/images/scenes/game-over-background.jpg");
    }

    @Override
    public void run() {
        //c2 frameCounter
        if (KeyPressed.getInstance().anyKeyPressed){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SceneManager.signNewScene(new GameWelcomeScene());
        }
    }

}
