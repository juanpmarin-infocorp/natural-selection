import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Circle
{
    
    public static final int INITIAL_PLAYER_RADIUS = 24;
    public static final int LOOSE_OFFSET = 10;
    
    private boolean enabled = true;
    private boolean quiet = true;
    
    private World world;
    
    private String name;
    private KeySet keySet;
    
    
    public Player(String name, Color color, KeySet keySet, int initialRadius) {
        super(color, initialRadius);
        this.name = name;
        this.keySet = keySet;
        setRadius(initialRadius);
    }
    
    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.world = world;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {            
        if (enabled) {
            handleDownKeys();
            eat();
            
            if (!quiet) {
                int movements = 200 / getRadius();
                move(movements == 0 ? 1 : movements);
            }
        }
    }
    
    private void handleDownKeys() {        
        boolean upPressed = Greenfoot.isKeyDown(this.keySet.getUp());
        boolean downPressed = Greenfoot.isKeyDown(this.keySet.getDown());
        boolean rightPressed = Greenfoot.isKeyDown(this.keySet.getRight());
        boolean leftPressed = Greenfoot.isKeyDown(this.keySet.getLeft());
        
        if (upPressed || downPressed || rightPressed || leftPressed) {
            quiet = false;
        }
        
        boolean invalid = !(upPressed ^ downPressed) && !(rightPressed ^ leftPressed);
        
        if (!invalid) {       
            int rotation = 0;
            int pressed = 0;
            
            if (rightPressed) {
                rotation += upPressed ? 360 : 0;
                pressed++;
            }
            
            if (downPressed) {
                rotation += 90;
                pressed++;
            }
            
            if (leftPressed) {
                rotation += 180;
                pressed++;
            } 
            
            if (upPressed) {
                rotation += 270;
                pressed++;
            }          

            setRotation(rotation / pressed);
        }
    }
    
    private void eat() {
        if (world instanceof AgarWorld) {
            List<Circle> intersectingCircles = getObjectsInRange(getRadius(), Circle.class);
            
            if (intersectingCircles.size() > 0) {        
                for (Circle circle : intersectingCircles) {
                    ((AgarWorld) world).eat(this, circle);
                }
                
                render();
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return getRadius() - INITIAL_PLAYER_RADIUS;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
