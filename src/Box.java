import java.awt.*;

public class Box extends GameObject {
    public Box(int x, int y) {
        super(x, y);

        velx = 1;
    }

    @Override
    public void tick() {
        x += velX;
        x += velY;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
