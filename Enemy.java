import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Bouncer
{
    public Enemy()
    {
        velocity.x = 3;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor player = ((GameWorld) getWorld()).mainPlayer;
        int playerx = player.getX();
        if (!flying && Math.abs(getX() - (player.getX() + 400)) < 10) {
            // In the "jump zone"
            velocity.y = 10;    // Jump!
        }
        super.act();
    }    
}
