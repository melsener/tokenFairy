import java.awt.*;
import java.io.File;
import java.util.Random;

/**
 * Created by melisaMac on 29/04/2017.
 */
public class Constant {

    public static Random RANDOMIZER = new Random();

    public static final int STUDENT_WIDTH = 40;
    public static final int STUDENT_HEIGHT= 40;
    public static final int MAX_REST_DURATION = 10;
    public static final int LEAVE_TO_REST_PROBABILITY = 1000;
    public static final int STUDENT_MIN_SPEED = 2;
    public static final int STUDENT_MAX_SPEED = 10;


    public static final int TOKEN_WIDTH = 20;
    public static final int TOKEN_HEIGHT= 20;

    public static final int AVAILABLE_TOKENS = 70;

    public static final int TOKEN_PACK_MAX = 50;
    public static final int TOKEN_PACK_MIN = 1;

    public static final int SPEED_PACK_PROBABILITY = 150;


    public static int FAIRY_IMG_WIDTH;
    public static int FAIRY_IMG_HEIGHT;

    public static final File FAIRY_LEFT = new File("imageL.png");
    public static final File FAIRY_RIGHT = new File("imageR.png");


    public static final Color CUSTOM_COURSE_COLOR1 = new Color(20, 207, 106);
    public static final Color CUSTOM_COURSE_COLOR2 = new Color(22, 184, 190);
    public static final Color CUSTOM_COURSE_COLOR3 = new Color(196, 10, 147);

    public static final Font COURSE_FONT = new Font("Courier New",Font.BOLD,12);

    public static final int COURSE_HEIGHT = 50;

    public static Stroke COURSE_BORDER= new BasicStroke(2);

    public static int DECORATOR_WIDTH = 5;
    public static int DECORATOR_HEIGHT = 10;








}
