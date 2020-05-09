import java.awt.*;
import java.awt.image.BufferedImage;

public class crate extends GameObject {

    private BufferedImage crate_image;

    public crate(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id, ss);
        crate_image = ss.grabImage(6, 2, 32, 32);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(crate_image, x, y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
