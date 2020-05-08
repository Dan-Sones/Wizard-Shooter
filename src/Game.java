import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private Boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private BufferedImage sprite_sheet = null;
    private BufferedImage level = null;
    private Camera camera;

    public Game() {
        new Window(1000, 563, "Wizard Shooter", this);
        start();

        handler = new Handler();
        camera = new Camera(0, 0);
        this.addKeyListener(new KeyInput(handler));
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("map.png");
        loadLevel(level);


    }

    private void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }//Start end

    private void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//Stop end

    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                //updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
                //updates = 0;
            }
        }
        stop();
    }//run

    private void render() {
        //Make a buffer strategy - preloads frames before they're shown to the user
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3); // What ever is inside the parenthesis is the number that are preloaded
            //three suposedely offers the best peformance
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        ////////////////////////////////////////
        // Anything between these comments is shown to the screen
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);
        g2d.translate(-camera.getX(), -camera.getY());



        handler.render(g);
        g2d.translate(camera.getX(), camera.getY());
        ////////////////////////////////////////
        g.dispose();
        bs.show();

    }// render

    //loading the level
    private void loadLevel (BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++ ){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if(red == 255){
                    handler.addObject(new Block(xx*32, yy*32, ID.Block));
                }
                if(blue == 255){
                    handler.addObject(new Wizard(xx*32, yy*32, ID.Player, handler));
                }
            }
        }
    }

    private void tick() {
        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.Player){
                camera.tick(handler.object.get(i));
            }
        }

        handler.tick();
    }


}//class

























