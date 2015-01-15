import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Bouncer
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up")) {
            velocity.y = -5;
            flying = true;
        }
        //if (Greenfoot.isKeyDown("down")) {
        //    setLocation(getX(), getY() + 3);
        //}
        if (Greenfoot.isKeyDown("left")) {
            velocity.x = -2;
        } else if (Greenfoot.isKeyDown("right")) {
            velocity.x = 2;
        } else {
            velocity.x = 0;
        }
       super.act();
    }    
}
