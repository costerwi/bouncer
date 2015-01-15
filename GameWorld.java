import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends ScrollingWorld
{
    Player mainPlayer;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        loadLevel("levels.png");
        mainPlayer = new Player();
        addObject(mainPlayer, 100, 100);
    }
    
    public void act()
    {
        //scrollPosition.x += 0.001;
        scrollPosition.x = mainPlayer.position.x - 100;
        //double dx = mainPlayer.position.x - scrollPosition.x - 100;
        //scrollPosition.x += 0.01*dx;
        //repaint();
    }
    
    public void loadLevel(String filename)
    {
        GreenfootImage levels = new GreenfootImage(filename);
        for (int y = 0; y < levels.getHeight(); y++) {
            for (int x = 0; x < levels.getWidth(); x++) {
                Color c = levels.getColorAt(x, y);
                if (c.equals(Color.black)) {
                    addObject(new Sand(), x*60, y*60);
                }
            }
        }
    }
}
