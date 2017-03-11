import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle extends Actor
{
    private Color color;
    private int radius;
    
    
    public Circle(Color color, int radius) {  
        this.color = color;
        this.radius = radius;
    }
    
    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        render();
    }
    
    protected void render() {
        GreenfootImage img = new GreenfootImage(radius * 2, radius * 2);
        
        img.setColor(color);
                
        img.fillOval(0, 0, radius * 2, radius * 2);
        setImage(img);
    }
    
    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public int bumpRadius() {
        return ++radius;
    }
}
