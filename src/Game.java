import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private Boolean isRunning = false;
    private Thread thread;
    private Handler handler;

    public Game() {
        new Window(1000, 563, "Wizard Shooter", this);
        start();

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        handler.addObject(new Wizard(100, 100, ID.Player, handler));


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
        ////////////////////////////////////////
        // Anything between these comments is shown to the screen
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);

        handler.render(g); //MUST BE AT THE BOTTOM!!!!!
        ////////////////////////////////////////
        g.dispose();
        bs.show();

    }// render

    private void tick() {
        handler.tick();
    }


}//class
