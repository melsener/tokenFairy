
import java.awt.*;


public abstract class StudentDecorator extends Student {

    public StudentDecorator(Student s) {
        super(s);
        decoratedStudent = s;
    }

    protected Student decoratedStudent;
    protected Color courseColor;

    public abstract void draw(Graphics2D g2d);


}