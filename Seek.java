
import java.awt.*;
import java.util.*;


public class Seek extends State {


    public Seek() {

    }


    public void act(Student student, int deltaTime, Data data){
        // TODO implement here
        int tokenIndex = data.findClosestToken(student.position);
        Vector2D dir = student.position.getDirection(data.tokens.get(tokenIndex).getPosition());
        student.position.setX(student.position.getX() + dir.getX() * student.speed);
        student.position.setY(student.position.getY() + dir.getY() * student.speed);

        if(student.position.doOverLapToken(data.tokens.get(tokenIndex).getPosition()))
        {
            if(data.tokens.get(tokenIndex) instanceof SpeedPack)
            {
                    student.incrementSpeed();
            }
            else
                student.incrementTokenCount( data.tokens.get(tokenIndex).getCount());
            data.tokens.remove(tokenIndex);
        }

        int cIndex = data.canDeposit(student);
        //deposit if you have a little bit more

        int rInt = Constant.RANDOMIZER.nextInt(100);
        if(deltaTime == rInt)
        {
            State backup = student.getState();
            student.setState(new Rest(backup));

        }
        else if(cIndex!=-1 && student.getTokenCount() >(data.minTokenRequired()/2) )
        {
            student.setState(new Deposit(cIndex));

        }

    }
    public Color getColor(){
        return Color.gray;
    }


}