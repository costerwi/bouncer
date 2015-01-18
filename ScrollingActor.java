import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A variation of an actor that maintains a precise location (using doubles for the co-ordinates
 * instead of ints).  This allows small precise movements (e.g. movements of 1 pixel or less)
 * that do not lose precision.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * @author Neil Brown
 * 
 * @version 3.0
 */
public abstract class ScrollingActor extends Actor
{
    protected Vector2D position;
    
    public ScrollingActor()
    {
        position = new Vector2D(0, 0);
    }
    
    @Override
    public void act() {
        updateLocation();
    }
    
    /**
     * Make sure ScrollingActor.position is updated whenever setLocation is called.
     */
    @Override
    public void setLocation(int x, int y) {
        position.setLocation((double) x, (double) y);
        updateLocation();
    }
    
    /**
     * Update Actor.x and Actor.y based on ScrollingActor.position relative to 
     * ScrollingWorld.position
     */
    public void updateLocation()
    {
        Vector2D w = position;
        w.subtract(getWorld().getScroll()); // Calculate relative position within scrolled window
        super.setLocation((int) w.x, (int) w.y);
    }
    
    public double getBouncyness()
    {
        return -0.5;
    }
    
    /**
     * Get the current world casted to ScrollingWorld.
     */
    @Override
    public ScrollingWorld getWorld() {
        return ((ScrollingWorld) super.getWorld());
    }

}
