import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Bouncer
{
    public void act() 
    {
        if (getY() > getWorld().getHeight()) {
            // Jumped off the edge: advance to next level!
            GameWorld w = (GameWorld) getWorld();
            w.loadNextLevel();
        }
        
        if (Greenfoot.isKeyDown("up") && !flying) {
            velocity.y = -6;    // Start a jump!
            flying = true;
        }

        if (Greenfoot.isKeyDown("left")) {
            velocity.x = Math.max(-4, velocity.x - 0.2);
        } else if (Greenfoot.isKeyDown("right")) {
            velocity.x = Math.min(+4, velocity.x + 0.2);
        } else {
            velocity.x = 0;
        }
        
        super.act();
    }    
}
