import java.awt.geom.Point2D;

/**
 * Write a description of class Vector2D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector2D extends Point2D.Double
{
    /**
     * Constructor for objects of class Vector2D
     */
    public Vector2D(double x, double y)
    {
        super(x, y);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void add(Vector2D other)
    {
        setLocation(x + other.getX(), y + other.getY());
    }
    
    public void subtract(Vector2D other)
    {
        setLocation(x - other.getX(), y - other.getY());
    }
    
    public void scale(double s)
    {
        setLocation(s*x, s*y);
    }
}
