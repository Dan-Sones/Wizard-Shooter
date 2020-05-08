import javax.swing.*;
import java.awt.*;

public class Window {
    public Window(int width, int height, String title, Game game){
        //Create A JFrame
        JFrame frame = new JFrame(title);
        //Setup frame size
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        //Add the game method to the JFrame
        frame.add(game);
        //make the window un-resizable
        frame.setResizable(false);
        //Close the window when X is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Start the frame in the very center of the window
        frame.setLocationRelativeTo(null);
        //Make the window visible
        frame.setVisible(true);

    }
}
