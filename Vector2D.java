
public class Vector2D {

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    private double x;
    private double y;

    public int getIntX() {

        return (int)x;
    }
    public int getIntY() {

        return (int) y;
    }
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double length()
    {
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }
    public void normalize()
    {   double len = this.length();
        if(len!=0)
        {
            this.x/=len;
            this.y/=len;
        }
        else
        {   //BEWARE!
            this.x/=1;
            this.y/=1;
        }
    }

    public double distanceTo(Vector2D other) {
        double dsquared = Math.pow(this.x - other.x,2) + Math.pow(this.y-other.y,2);
        return Math.sqrt(dsquared);
    }
    Vector2D getDirection(Vector2D other){
        Vector2D dir = new Vector2D(other.x - this.x,other.y - this.y);
        dir.normalize();
        return dir;
    }

    Vector2D getDirectionToCourse(Vector2D other)
    {
        Vector2D modifiedPos = new Vector2D(other.x,other.y + 40);
        Vector2D dir = new Vector2D(modifiedPos.x - this.x , modifiedPos.y - this.y);
        dir.normalize();
        return dir;
    }

    public boolean doOverLapToken(Vector2D other)
    {
        if(this.x + Constant.STUDENT_WIDTH < other.x || other.x + Constant.TOKEN_WIDTH < this.x || this.y + Constant.STUDENT_HEIGHT < other.y || other.y + Constant.TOKEN_HEIGHT < this.y)
            return false;
        return true;
    }

    public boolean onCourse(Vector2D other, int width ,int height)
    {
        if(this.x < other.x || this.x > other.x + width || this.y > other.y + height)
            return false;
        return true;

    }



}