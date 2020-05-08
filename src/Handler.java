import java.awt.*;
import java.util.LinkedList;

public class Handler {

    // An array of objects
    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i  = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }// tick

    public void render(Graphics g){
        for(int i  = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }// render

    //Add objects from the linked list
    public void addObject(GameObject tempObject){
        object.add(tempObject);
    }
    //Remove objects from the linked list
    public void removeObject(GameObject tempObject){
        object.remove(tempObject);
    }
}// class

