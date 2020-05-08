import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {

    // An array of objects
    ArrayList<GameObject> object = new ArrayList<GameObject>();

    private boolean up = false, down = false, right = false, left = false;

    public void tick() {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }// tick

    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }// render

    //Add objects from the linked list
    public void addObject(GameObject tempObject) {
        object.add(tempObject);
    }

    //Remove objects from the linked list
    public void removeObject(GameObject tempObject) {
        object.remove(tempObject);
    }

    //Getters and setters


    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}// class

