package renderer;

import bases.GameObject;
import bases.Vector2D;

import java.awt.*;

public interface Renderer {
    void render(Graphics g, GameObject master);

}
