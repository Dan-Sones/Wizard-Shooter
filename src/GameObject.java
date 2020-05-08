import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected float velX = 0, velY = 0;

    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    // Tick constructor
    public abstract void tick();
    //render
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    //Getters and setters
    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
