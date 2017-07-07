
import java.awt.*;
import java.util.*;


public abstract class State {


    public State() {
    }
    public abstract void act(Student student, int deltaTime, Data data);
    public abstract Color getColor();

}