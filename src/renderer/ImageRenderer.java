package renderer;

import bases.GameObject;
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
    public void render(Graphics g, GameObject master) {
        g.drawImage(this.image,
                (int) (master.position.x- master.anchor.x*this.image.getWidth(null)),
                (int) (master.position.y-master.anchor.y*this.image.getHeight(null)),
                null);
    }
}
