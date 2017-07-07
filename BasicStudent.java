
import java.awt.*;


public class BasicStudent extends Student {


    public BasicStudent(String name,Vector2D pos,int speed) {
        super();
        this.setName(name);
        this.setPosition(pos);
        this.setSpeed(speed);
        this.setTakenCourseCount(0);
        this.setTokenCount(0);
        this.setState(new Seek());
    }


    public void draw(Graphics2D g2d){

        //Draw Circle
        g2d.setPaint(Color.gray);
        g2d.drawOval(position.getIntX(),position.getIntY(),Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT);
        g2d.setPaint(Color.black);

        //Draw name and speed
        FontMetrics fm = g2d.getFontMetrics();
        double textWidth = fm.getStringBounds(name + "(" + speed + ")" , g2d).getWidth();
        g2d.drawString(name + "(" + speed + ")", (int) (position.getIntX() + (Constant.STUDENT_WIDTH -textWidth)/2), position.getIntY());

        //Draw state
        g2d.setPaint(getState().getColor());
        textWidth = fm.getStringBounds(getState().getClass().getName(), g2d).getWidth();
        g2d.drawString(getState().getClass().getName(), (int) (position.getIntX() +(Constant.STUDENT_WIDTH-textWidth)/2),position.getIntY()+(Constant.STUDENT_HEIGHT/2)-5);

        //Draw Course Count
        g2d.setPaint(Color.MAGENTA);
        textWidth = fm.getStringBounds(Integer.toString(takenCourseCount),g2d).getWidth();
        g2d.drawString(Integer.toString(takenCourseCount), (int) (position.getIntX()+(Constant.STUDENT_WIDTH - textWidth)/2),position.getIntY()+(Constant.STUDENT_HEIGHT/2)+5);

        //Draw Token Count
        g2d.setPaint(Color.GREEN);
        textWidth = fm.getStringBounds(Integer.toString(tokenCount),g2d).getWidth();
        g2d.drawString(Integer.toString(tokenCount), (int) (position.getIntX() + (Constant.STUDENT_WIDTH-textWidth)/2),position.getIntY()+(Constant.STUDENT_HEIGHT)+10);

    }

}