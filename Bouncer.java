import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;

/**
 * Write a description of class Bouncer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bouncer extends ScrollingActor
{
    // instance variables - replace the example below with your own
    protected Vector2D velocity;
    protected boolean flying;

    /**
     * Constructor for objects of class Bouncer
     */
    public Bouncer()
    {
        velocity = new Vector2D(0, 0);
        flying = true;
    }

    @Override
    public void act()
    {
        bounceOffStuff();
        move();
        super.act();
    }    
    
    public void bounceOffStuff()
    {
        //List l = getIntersectingObjects(ScrollingActor.class);
        //for(Iterator<ScrollingActor> i = l.iterator(); i.hasNext(); ) {
        //}
        //for (Object a : l) {
        //}
        
        List touchingObjects = getIntersectingObjects(ScrollingActor.class);
        if (touchingObjects.isEmpty()) {
            flying = true;
        } else {
            for (Object o : touchingObjects) {
                ScrollingActor a = (ScrollingActor) o; // cast from Object to ScrollingActor
                int dx = (getX() - a.getX());
                int dy = (getY() - a.getY());
                if (Math.abs(dx) > Math.abs(dy) + 2) {
                    // Touching object in horizontal direction
                    if (dx * velocity.x < 0) {
                        // Moving toward object
                        velocity.x *= -1;
                    }
                } else if (Math.abs(dy) > Math.abs(dx) + 2) {
                    flying = false;  // Allow jumping
                    if (Math.abs(velocity.y) < 1) {
                        velocity.y = 0; // Land on object
                    } else if (dy*velocity.y < 0) {
                        velocity.y *= a.getBouncyness();
                    }
                }
            }
        }
    }    
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void move()
    {
        position.add(velocity);
        if (flying) {
            velocity.y += 0.1;  // gravity
        }
    }
}
