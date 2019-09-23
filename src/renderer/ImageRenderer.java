package renderer;

import bases.SpriteUtils;
import bases.Vector2D;

import java.awt.*;

public class ImageRenderer implements Renderer {
    Image image;
    public ImageRenderer(String url){
        this.image = SpriteUtils.loadImage(url);
    }
    //neu ko giong interface dang implement hoac thieu method trong do thi se bao loi
    @Override
    public void render(Graphics g, Vector2D position) {
        g.drawImage(this.image, (int) position.x, (int) position.y, null);
    }
}
