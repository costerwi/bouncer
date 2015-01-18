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
    GreenfootImage levels;
    int nextLevel;
    
    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld()
    {    
        super(800, 600, 1);
        mainPlayer = new Player();
        addObject(mainPlayer, 150, 50);
        levels = new GreenfootImage("levels.png");
        nextLevel = 0;
        loadNextLevel();
    }
    
    public void act()
    {
        scrollPosition.x = mainPlayer.position.x - 150; // Scroll with player
    }
    
    public void loadNextLevel()
    {
        removeObjects(getObjects(Sand.class));
        removeObjects(getObjects(Brick.class));
        mainPlayer.setLocation(150, 50);
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < levels.getWidth(); x++) {
                Color c = levels.getColorAt(x, y + nextLevel*10);
                if (c.equals(Color.black)) {
                    addObject(new Sand(), x*60, y*60 + 30);
                } else if (c.equals(Color.red)) {
                    addObject(new Brick(), x*60, y*60 + 30);
                } else if (c.equals(Color.green)) {
                    addObject(new Enemy(), x*60, y*60 + 30);
                }
            }
        }

        nextLevel += 1;
        if (10*nextLevel + 10 > levels.getHeight()) {
            // Extended past the last level
            nextLevel = 0;  // Reset to first level
        }
    }
}
