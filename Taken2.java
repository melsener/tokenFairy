
import java.awt.*;

public class Taken2 extends StudentDecorator {


    public Taken2(Student s,Color c) {
        super(s);
        courseColor = c;

    }

    @Override
    public void draw(Graphics2D g2d){
        //Draw base
        decoratedStudent.setState(this.studentState);
        decoratedStudent.setTokenCount(this.tokenCount);
        decoratedStudent.setTakenCourseCount(this.takenCourseCount);
        decoratedStudent.setSpeed(this.speed);
        decoratedStudent.draw(g2d);
        //Add decoration
        g2d.setPaint(courseColor);
        g2d.fillRect(this.position.getIntX()+17+5,this.position.getIntY()+25,Constant.DECORATOR_WIDTH,Constant.DECORATOR_HEIGHT);
    }


}