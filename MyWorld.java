import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    private static final int COLOR_MIN = 50;
    private static final int COLOR_MAX = 230;   
    private static final int INITIAL_FOOD = 60;
    private static final int FOOD_RADIUS = 7;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 512, 1); 
        
        setBackground("images/background.jpg");
        
        this.setPaintOrder(Player.class, Circle.class);
        
        addPlayers();
        addFood();
    }
    
    private void addPlayers() {        
        KeySet leftKeySet = new KeySet("up", "down", "left", "right");
        Player leftPlayer = new Player(new Color(254, 86, 73), leftKeySet);
        
        KeySet rightKeySet = new KeySet("w", "s", "a", "d");
        Player rightPlayer = new Player(new Color(89, 234, 234), rightKeySet);
        rightPlayer.setRotation(180);
        
        addObject(leftPlayer, 150, getHeight() / 2);
        addObject(rightPlayer, getWidth() - 150, getHeight() / 2);
    }
    
    private void addFood() {
        for (int i = 0; i < INITIAL_FOOD; i++) {
            addFoodParticle();
        }
    }
    
    private void addFoodParticle() {
        List<Actor> objectsAtPosition = null;
        int x = 0;
        int y = 0;
        
        while(objectsAtPosition == null || objectsAtPosition.size() > 0) {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            
            objectsAtPosition = getObjectsAt(x, y, Actor.class);
        }
        Circle circle = new Circle(nextFoodColor(), FOOD_RADIUS);
        
        addObject(circle, x, y);
    }
    
    private Color nextFoodColor() {
        return new Color(
                Util.getRandomNumber(COLOR_MIN, COLOR_MAX),
                Util.getRandomNumber(COLOR_MIN, COLOR_MAX),
                Util.getRandomNumber(COLOR_MIN, COLOR_MAX),
                Util.getRandomNumber(COLOR_MIN, COLOR_MAX));
    }
    
}
