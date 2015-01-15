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
    protected Vector2D acceleration;
    protected boolean flying;

    /**
     * Constructor for objects of class Bouncer
     */
    public Bouncer()
    {
        velocity = new Vector2D(0, 0);
        acceleration = new Vector2D(0, 0.1);  // Gravity acting downward
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
        List l = getIntersectingObjects(ScrollingActor.class);
        //for(Iterator<ScrollingActor> i = l.iterator(); i.hasNext(); ) {
        //}
        for (Object a : l) {
        }
        Actor other = getOneIntersectingObject(Sand.class);
        
        if (null == other) {
            flying = true;  // Not touching anything
        } else {
            flying = false;
            if (velocity.y > 0) {
                if (velocity.y < 1) {
                    velocity.y = 0; // Land
                } else {
                    velocity.y *= -0.7; // Bounce but not as high
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
            velocity.add(acceleration);
        }
    }
}
