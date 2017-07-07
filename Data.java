
import java.awt.*;
import java.util.*;
import java.util.List;

public final class Data {

    //Initialize Data
    public Data(int width,int height) {
        windowWidth = width;
        windowHeight = height;
        tokens = new ArrayList<>();
        courses = new ArrayList<>();
        students = new ArrayList<>();

        fairy = new TokenFairy();
        fairy.setPosition(randomVectorGenerator(Constant.FAIRY_IMG_WIDTH,Constant.FAIRY_IMG_HEIGHT));
        for(int i = 0; i < Constant.AVAILABLE_TOKENS; i++){
            tokens.add(fairy.createToken(randomVectorGenerator(0,Constant.TOKEN_HEIGHT)));
        }
        setCourses();
        setStudents();
    }

    public int windowWidth;
    public int windowHeight;
    public TokenFairy fairy;
    public final List<Token> tokens;
    public final List<Course> courses;
    public final List<Student> students;
    public boolean took = false; //Indicates need for redecoration
    public int index = -1;

    public void setWindowSize(int width, int height)
    {
        windowWidth = width;
        windowHeight = height;
    }


    public void stepAllEntities(int counter)
    {
        //TO DO
        if(counter==5)
            fairy.act(counter,this);

        for(int i = 0;i<students.size();i++) {
            Student s =  students.get(i);
            s.act(counter, this);
            if(took)
            {
                took = false;
                if(s instanceof BasicStudent)
                {
                    students.set(i,new Taken1(s,courses.get(index).getColor()));
                }
                else if(s instanceof Taken1)
                {   s.setState(new Leave());
                    students.set(i,new Taken2(s,courses.get(index).getColor()));

                }
            }
        }
        cleanOuters();
    }
    public void reshape()
    {
        for(int i = 0 ; i < courses.size() ; i++)
        {
            courses.get(i).setWidth(windowWidth/8);
            courses.get(i).setXPosition(i*(windowWidth/8));
        }
        cleanTokensWhenReshape();
    }
    public int findClosestToken(Vector2D position)
    {
        double min = Double.MAX_VALUE;
        int index = 0;
        for(int i = 0; i< tokens.size();i++)
        {   double val = position.distanceTo(tokens.get(i).getPosition());
            if(min > val )
            {
                min = val;
                index = i;
            }
        }
        return index;
    }
    public int canDeposit(Student s)
    {
        int courseIndex = Constant.RANDOMIZER.nextInt(courses.size());
        if(s.tatec[courseIndex]!=-1)
            return courseIndex;
        return -1;
    }

    public int minTokenRequired()
    {
        int minToken = Integer.MAX_VALUE;
        for(Course c: courses)
        {
            if(c.getMinTokens() < minToken)
                minToken=c.getMinTokens();
        }
        return minToken;
    }

    public boolean canTake(Student s, int courseIndex)
    {
        return (s.tatec[courseIndex] + s.getTokenCount() >= courses.get(courseIndex).getMinTokens());
    }

    private void cleanOuters()
    {
        for(int i = 0; i < students.size() ; i++)
        {
            if(students.get(i).position.getY() > windowHeight && (students.get(i) instanceof Taken2)) {
                students.remove(i);
            }
        }
    }

    private void setCourses()
    {
        courses.add(new Course("CENG443", Color.red,80,new Vector2D(0,0) ,windowWidth/8));
        courses.add(new Course("CENG451", Color.yellow,20,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG462", Color.green,10,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG476", Constant.CUSTOM_COURSE_COLOR1,10,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG478", Constant.CUSTOM_COURSE_COLOR2,10,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG495", Color.blue,33,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG497", Color.magenta,10,new Vector2D(windowWidth/8,0) ,windowWidth/8));
        courses.add(new Course("CENG499", Constant.CUSTOM_COURSE_COLOR3,55,new Vector2D(windowWidth/8,0) ,windowWidth/8));
    }

    private void setStudents()
    {
        students.add(new BasicStudent("Abdulkadir", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Abdüllatif", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Afşin Buğra", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ahmet Alperen", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ahmet Selim", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Alihan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Alperen", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Andi", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ata", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Aybars Kerem", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Barış", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Barış Çağlar", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Batyr", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Berker", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Buğrahan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Burak", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Cantürk", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Doğuhan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Doğukan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ebru İpek", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Efecan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Enver", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Erbil", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Erinç", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ermek", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ertuğ", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Furkan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Gökhan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Halim Görkem", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Hasan Ali", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Ibrahim Bakarr", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("İlke", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("İzzet Barış", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Kadir Berkay", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Kadir Cenk", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mehmet", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mehmet Ali", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mehmet Can", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mehmet Sait", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Melisa İdil", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mert", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mert", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Mert", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Merve", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Metehan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Muhammet", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Oğuz", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Okan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Onat", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Onur", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Onur Ozan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Özgü", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Pınar", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Recep Fırat", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Recep Gün", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Sait Burak", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Sercan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Sercan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Sinan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Şükrü", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Tolga", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Tolgahan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Tuğçe Alara", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Uğur", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Uğurcan", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Yasin Berk", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));
        students.add(new BasicStudent("Yiğit", randomVectorGenerator(Constant.STUDENT_WIDTH,Constant.STUDENT_HEIGHT),Constant.RANDOMIZER.nextInt(Constant.STUDENT_MAX_SPEED-Constant.STUDENT_MIN_SPEED)+Constant.STUDENT_MIN_SPEED));

    }

    public Vector2D randomVectorGenerator(int elementWidth, int elementHeight)
    {
        Vector2D randomVector = new Vector2D(Constant.RANDOMIZER.nextInt(windowWidth-elementWidth),Constant.RANDOMIZER.nextInt(windowHeight-elementHeight-Constant.COURSE_HEIGHT)+Constant.COURSE_HEIGHT);
        return randomVector;
    }

    private void cleanTokensWhenReshape()
    {
        for(int i = 0 ; i< tokens.size();i++)
        {
            if(tokens.get(i).getPosition().getX() > windowWidth || tokens.get(i).getPosition().getY() > windowHeight )
                tokens.remove(i);
        }
    }

}
