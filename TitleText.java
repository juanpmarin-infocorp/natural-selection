import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleText extends TextView
{
    private static final int FONT_SIZE = 72;
    
    public TitleText(String title) {
        super(title, FONT_SIZE);
        setBackgroundColor(new Color(0, 0, 0, 20));
    }
    
    /**
     * Act - do whatever the TitleText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
