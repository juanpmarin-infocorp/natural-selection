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
    
    private static final int LOOSE_OFFSET = 10;
    
    private boolean enabled = true;
    private MyWorld world;
    private KeySet keySet;
    
    
    public Player(Color color, KeySet keySet, int initialRadius) {
        super(color, initialRadius);
        this.keySet = keySet;
        setRadius(initialRadius);
    }
    
    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        this.world = (MyWorld)world;
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
            
            int movements = 200 / getRadius();
            move(movements == 0 ? 1 : movements);
        }
    }
    
    private void handleDownKeys() {        
        boolean upPressed = Greenfoot.isKeyDown(this.keySet.getUp());
        boolean downPressed = Greenfoot.isKeyDown(this.keySet.getDown());
        boolean rightPressed = Greenfoot.isKeyDown(this.keySet.getRight());
        boolean leftPressed = Greenfoot.isKeyDown(this.keySet.getLeft());
        
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
        List<Circle> intersectingCircles = getObjectsInRange(getRadius(), Circle.class);
        
        if (intersectingCircles.size() > 0) {        
            for (Circle circle : intersectingCircles) {
                if (circle instanceof Player) {
                    Player enemy = (Player) circle;
                    if (enemy.getRadius() >= getRadius() - LOOSE_OFFSET) {
                        continue;
                    } else {
                        world.win(this);
                    }
                } else {
                    world.addFoodParticle();
                    bumpRadius();
                }
                
                world.removeObject(circle);
            }
            
            render();
        }
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
