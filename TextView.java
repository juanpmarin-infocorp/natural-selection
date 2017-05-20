import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextView here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextView extends Actor
{    
    public static int DEFAULT_TEXT_SIZE = 14;
    public static Color PRIMARY_TEXT_COLOR = new Color(82, 85, 82);
    
    
    private boolean shouldRender = false;
    
    private String text;
    private int fontSize = DEFAULT_TEXT_SIZE;
    
    private Color color = PRIMARY_TEXT_COLOR;
    private Color backgroundColor = new Color(0, 0, 0, 0);
    
    
    public TextView(String text, int fontSize) {
        this.text = text;
        this.fontSize = fontSize;
    }
    
    public TextView(String text, int fontSize, Color color) {
        this.text = text;
        this.fontSize = fontSize;
        this.color = color;
    }
    
    private void render() {
        setImage(new GreenfootImage(text, fontSize, color, backgroundColor));
    }
    
    protected void addedToWorld(World world) {
        render();
    }
    
    public void act() 
    {
        if (shouldRender) {
            render();
            shouldRender = false;
        }
    }   
    
    public void setText(String text) {
        this.text = text;
        this.shouldRender = true;
    }
    
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
