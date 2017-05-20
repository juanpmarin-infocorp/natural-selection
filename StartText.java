import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartText extends SubTitleText
{
    private int frame = 1;
    private int initialY;
    
    public StartText() {
        super("Press <space> to start");
    }
    
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        initialY = getY();
    }
    
    public void act() 
    {        
        // Subtitle bouncing
        int translation = bounce(frame / 4, 24);
        setLocation(getX(), initialY + translation);
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new AgarWorld());
        }
        
        frame += 1;
    }    
    
    public int bounce(int frame, int duration) {
        int value = (frame % duration);
        if (value > duration / 2) {
            return duration - value;
        }
        
        return value;
    }
}
