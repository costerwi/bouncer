import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Write a description of class ScrollingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ScrollingWorld extends World
{
    // instance variables - replace the example below with your own
    protected Vector2D scrollPosition;

    public ScrollingWorld(int worldWidth, int worldHeight, int cellSize)
    {
        super(worldWidth, worldHeight, cellSize, false);
        scrollPosition = new Vector2D(0, 0);
    }
    
    public Vector2D getScroll()
    {
        return scrollPosition;
    }
}
