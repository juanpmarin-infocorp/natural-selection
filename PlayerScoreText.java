import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerScoreText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerScoreText extends Actor
{
    private static final Color COLOR = new Color(82, 85, 82);
    private static final int FONT_SIZE = 24;
    
    private Player player;
    
    
    public PlayerScoreText(Player player) {
        this.player = player;
    }
    
    public void addedToWorld(World world) {
        render();
    }
    
    public void render() {
        setImage(new GreenfootImage(player.getName() + ": " + player.getScore(), FONT_SIZE, COLOR, new Color(0, 0, 0, 5)));
    }
    
    /**
     * Act - do whatever the PlayerScoreText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        render();
    }
}
