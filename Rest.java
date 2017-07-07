
import java.awt.*;
import java.util.*;

public class Rest extends State {

    public Rest(State previous) {
        duration = Constant.RANDOMIZER.nextInt(Constant.MAX_REST_DURATION);
        prevState= previous;
    }
    private int duration;
    private State prevState;


    public void act(Student student, int deltaTime, Data data){
        // DO NOT MOVE
        if(duration == 0)
        {   student.setState(prevState);
            duration = Constant.RANDOMIZER.nextInt(Constant.MAX_REST_DURATION);
        }
        else
            duration--;
    }

    public Color getColor(){
        return Color.gray;
    }

}