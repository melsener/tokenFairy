
import java.awt.*;
import java.util.*;


public class Deposit extends State {


    public Deposit(int cIn) {
        courseIndex=cIn;
        stateCol = Color.black;
    }
    private int courseIndex;
    private Color stateCol;

    public void act(Student student, int deltaTime, Data data){
        int rInt = Constant.RANDOMIZER.nextInt(100);
        stateCol = data.courses.get(courseIndex).getColor();
        Vector2D dir = student.position.getDirectionToCourse(data.courses.get(courseIndex).getPosition());
        if(courseIndex!=-1 && student.position.onCourse(data.courses.get(courseIndex).getPosition(),data.courses.get(courseIndex).getRECTANGLE_WIDTH(),data.courses.get(courseIndex).getRECTANGLE_HEIGHT()))
        {
            if(!data.canTake(student,courseIndex))
            {   student.tatec[courseIndex]+=student.getTokenCount();
                student.setTokenCount(0);
                student.setState(new Seek());
            }
            else if(data.canTake(student,courseIndex))
            {   data.took = true;
                data.index = courseIndex;
                data.courses.get(courseIndex).incrementTakenStudentCount();

                student.decrementTokenCount(data.courses.get(courseIndex).getMinTokens()-student.tatec[courseIndex]);

                student.tatec[courseIndex]=-1;

                int taken = student.getTakenCourseCount();
                if(student instanceof Taken1)
                {

                    student.incrementTakenCourseCount();


                }
                else if(student instanceof  BasicStudent)
                {

                    student.setState(new Seek());
                    student.incrementTakenCourseCount();

                }
                courseIndex=-1;
            }
        }
        else if(courseIndex!=-1 && deltaTime ==rInt)
        {   State backup = student.getState();
            student.setState(new Rest(backup));
        }
        student.position.setX(student.position.getX() + dir.getX() * student.speed);
        student.position.setY(student.position.getY() + dir.getY() * student.speed);
    }

    public Color getColor() {
        return stateCol;
    }
}