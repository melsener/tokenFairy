
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 
 */
public abstract class Student implements AnimationEntity {

    protected String name;
    protected Vector2D position;
    protected int speed;
    protected int takenCourseCount = 0;
    protected int tokenCount = 0;
    protected State studentState;
    protected int[] tatec = new int[]{0,0,0,0,0,0,0,0};


    public Student(){
    }

    public Student(Student s)
    {
        this.setName(s.getName());
        this.setPosition(s.getPosition());
        this.setSpeed(s.getSpeed());
        this.setTakenCourseCount(s.getTakenCourseCount());
        this.setTokenCount(s.getTakenCourseCount());
        this.setState(s.getState());
        this.setTatec(s.getTatec());
    }

    public abstract void draw(Graphics2D g2d);
    public void act(int deltaTime, Data data){
        studentState.act(this,deltaTime,data);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPosition(Vector2D pos) {
        this.position = pos;
    }
    public Vector2D getPosition(){
        return position;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed()
    {   return speed;
    }

    public void setState(State state) {
        this.studentState = state;
    }
    public State getState() {
        return studentState;
    }

    public void setTatec(int [] tatec)
    {
        this.tatec = tatec;
    }
    public int [] getTatec()
    {
        return tatec;
    }

    public void setTakenCourseCount(int a)
    {
        takenCourseCount=a;
    }
    public int getTakenCourseCount()
    {   return takenCourseCount;
    }
    public void incrementTakenCourseCount()
    {   takenCourseCount++;
    }

    public void setTokenCount(int a)
    {   tokenCount = a;
    }
    public int getTokenCount()
    {   return tokenCount;
    }

    public void incrementTokenCount(int plus)
    {   tokenCount = getTokenCount() + plus;
    }
    public void decrementTokenCount(int minus)
    {   tokenCount = getTokenCount() - minus;
    }

    public void incrementSpeed()
    {   speed++;
    }




}