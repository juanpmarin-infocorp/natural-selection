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
    private static final int INITIAL_FOOD = 60;
    private static final int FOOD_RADIUS = 7;
    
    private Player[] players;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(896, 768, 1);
        
        setBackground("images/background.jpg");
        
        this.setPaintOrder(WinnerText.class, PlayerScoreText.class, Player.class, FoodParticle.class);
        
        addPlayers();
        addFood();
    }
    
    private void addPlayers() {        
        KeySet leftKeySet = new KeySet("up", "down", "left", "right");
        Player leftPlayer = new Player("Red player", new Color(254, 86, 73), leftKeySet, Player.INITIAL_PLAYER_RADIUS);
        
        KeySet rightKeySet = new KeySet("w", "s", "a", "d");
        Player rightPlayer = new Player("Blue player", new Color(89, 234, 234), rightKeySet, Player.INITIAL_PLAYER_RADIUS);
        rightPlayer.setRotation(180);
        
        addObject(leftPlayer, 150, getHeight() / 2);
        addObject(rightPlayer, getWidth() - 150, getHeight() / 2);
        
        addObject(new PlayerScoreText(leftPlayer), getWidth() / 2, 36);
        addObject(new PlayerScoreText(rightPlayer), getWidth() / 2, 62);
        
        players = new Player[]{leftPlayer, rightPlayer};        
    }
    
    private void addFood() {
        for (int i = 0; i < INITIAL_FOOD; i++) {
            addFoodParticle();
        }
    }
    
    public void addFoodParticle() {
        List<Actor> objectsAtPosition = null;
        int x = 0;
        int y = 0;
        
        while(objectsAtPosition == null || objectsAtPosition.size() > 0) {
            x = Greenfoot.getRandomNumber(getWidth());
            y = Greenfoot.getRandomNumber(getHeight());
            
            objectsAtPosition = getObjectsAt(x, y, Actor.class);
        }
        FoodParticle foodParticle = new FoodParticle(FOOD_RADIUS);
        
        addObject(foodParticle, x, y);
    }
    
    public void win(Player player) {
        int i = 0;
        for (i = 0; i < players.length; i++) {
            if (players[i] == player) {
                Actor winnerText = new WinnerText(players[i]);        
                addObject(winnerText, getWidth() / 2, getHeight() / 3);
                break;
            }
        }
        
        player.setEnabled(false);
        player.setLocation(getWidth() / 2, getHeight() / 2);
        
        List<FoodParticle> foodParticles = getObjects(FoodParticle.class);
        for (FoodParticle foodParticle : foodParticles) {
            removeObject(foodParticle);
        }
    }
}
