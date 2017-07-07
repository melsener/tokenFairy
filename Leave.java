
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Leave extends State {


    public Leave() {
    }

    public void act(Student student, int deltaTime, Data data){

        student.position.setY(student.position.getY() + 1 * student.speed);
        int rInt = Constant.RANDOMIZER.nextInt(Constant.LEAVE_TO_REST_PROBABILITY);
        if(rInt == deltaTime)
        {   State backup = student.getState();
            student.setState(new Rest(backup));
        }
    }


    public Color getColor() {
        return Color.gray;
    }


}