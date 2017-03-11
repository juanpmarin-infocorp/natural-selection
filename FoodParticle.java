import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FoodParticle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoodParticle extends Circle
{
    
    private static final int FOOD_RADIUS = 7;
    private static final int COLOR_MIN = 50;
    private static final int COLOR_MAX = 230;   
    
    public FoodParticle(int radius) {
        super(Util.randomColor(COLOR_MIN, COLOR_MAX), radius);
    }
    
    /**
     * Act - do whatever the FoodParticle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
