import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Circle
{
    
    private static final int RADIUS = 24;
    
    private KeySet keySet;
    
    
    public Player(Color color, KeySet keySet) {
        super(color, RADIUS);
        this.keySet = keySet;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown(this.keySet.getUp())) {
            setRotation(270);
        }
        
        if (Greenfoot.isKeyDown(this.keySet.getDown())) {
            setRotation(90);
        }
        
        if (Greenfoot.isKeyDown(this.keySet.getLeft())) {
            setRotation(180);
        }
        
        if (Greenfoot.isKeyDown(this.keySet.getRight())) {
            setRotation(0);
        }
        
        move(4);
    }    
}
