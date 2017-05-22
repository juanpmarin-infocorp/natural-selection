import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerScoreText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerScoreText extends TextView
{
    private static final int FONT_SIZE = 24;
    
    private Player player;
    
    
    public PlayerScoreText(Player player) {
        super("", FONT_SIZE);
        this.player = player;
    }
    
    public void addedToWorld(World world) {
        super.addedToWorld(world);
        updateScore();
    }
    
    public void updateScore() {
        setText(player.getName() + ": " + player.getScore());
    }
    
    /**
     * Act - do whatever the PlayerScoreText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        updateScore();
    }
}
