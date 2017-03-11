import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinnerText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinnerText extends Actor
{
    private static final Color COLOR = new Color(82, 85, 82);
    private static final int FONT_SIZE = 72;
    
    
    public WinnerText(Player player) {
        setImage(new GreenfootImage(player.getName() + " wins!", FONT_SIZE, COLOR, new Color(0, 0, 0, 20)));
    }    
}
