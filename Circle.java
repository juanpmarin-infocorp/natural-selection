import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{   
    
    public Circle(Color color, int radius) {
        GreenfootImage img = new GreenfootImage(radius*2, radius*2);
        
        img.setColor(color);
                
        img.fillOval(0, 0, radius*2, radius*2);
        setImage(img);        
    }
    
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
