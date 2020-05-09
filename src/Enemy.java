import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {

    private Handler handler;
    Random r = new Random();
    int choose = 0;
    int hp = 100;

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        //Make choose a random number from 0-9
        choose = r.nextInt(10);

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Block) {
                if (getBoundsBig().intersects(tempObject.getBounds())) {
                    //Go back in the opposite direction if you go near a wall
                    x += (velX * 5) * -1;
                    y += (velY * 5) * -1;
                    velX *= -1;
                    velY *= -1;
                } else if (choose == 0) {
                    velX = (r.nextInt(4 - -4)) + -4;
                    velY = (r.nextInt(4 - -4)) + -4;
                }
            }

            if(tempObject.getId() == ID.Bullet){
                if(getBounds().intersects(tempObject.getBounds())){
                    hp -= 50;
                    handler.removeObject(tempObject);
                }

            }
        }//For
        //remove the object if thet have 0 hp
        if(hp <= 0) handler.removeObject(this);




    }//tick

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 32, 32);

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.green);
        //Uncomment the line below to see boundaries of the enemies
        //g2d.draw(getBoundsBig());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y, 32,32);
    }


    public Rectangle getBoundsBig() {
        //Slightly bigger border size
        return new Rectangle(x-16,y-16, 64,64);
    }
}
