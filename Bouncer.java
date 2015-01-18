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
    protected Vector2D velocity;
    protected boolean flying; // True when gravity is affecting Bouncer

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
        List touchingObjects = getIntersectingObjects(ScrollingActor.class);
        if (touchingObjects.isEmpty()) {
            flying = true;  // could happen if player steps off a cliff
        } else {
            for (Object o : touchingObjects) {
                ScrollingActor a = (ScrollingActor) o; // cast from Object to ScrollingActor
                int dx = (getX() - a.getX());
                int dy = (getY() - a.getY());
                if (Math.abs(dx) > Math.abs(dy) + 2) {
                    // Touching object in horizontal direction
                    if (dx * velocity.x < 0) {
                        // Moving toward object
                        velocity.x *= -1;  // Perfect bounce
                    }
                } else if (Math.abs(dy) > Math.abs(dx) + 2) {
                    // Touching object "a" in vertical direction
                    flying = false;  // No longer in air; allow jumping
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
     * Update the position member based on current velocity.
     */
    public void move()
    {
        position.add(velocity);
        if (flying) {
            velocity.y += 0.1;  // gravity
        }
    }
}
