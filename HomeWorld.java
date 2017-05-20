import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeView here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeWorld extends World
{    
    private TextView titleView;
    private TextView subTitleView;
    
    private int frame = 1;
    
    
    public HomeWorld()
    {    
        super(896, 768, 1);
        
        titleView = new TitleText("Natural Selection");
        addObject(titleView, getWidth() / 2, getHeight() / 3);
        
        subTitleView = new StartText();
        addObject(subTitleView, getWidth() / 2, getHeight() / 2);        
        
        addPlayers();
    }
    
    private void addPlayers() {
        Color commonColor = new Color(205, 205, 205);
        
        Player leftPlayer = new Player(null, commonColor, null, Player.INITIAL_PLAYER_RADIUS);
        Player rightPlayer = new Player(null, commonColor, null, Player.INITIAL_PLAYER_RADIUS);
        
        leftPlayer.setEnabled(false);
        rightPlayer.setEnabled(false);
        
        addObject(leftPlayer, 150, getHeight() / 2);
        addObject(rightPlayer, getWidth() - 150, getHeight() / 2);
    }
    
    public void act() 
    {
        int transparency = frame * 5;
        
        // FadeIn
        if (transparency <= 255) {
            titleView.getImage().setTransparency(transparency);
        }
        
        frame += 1;
    }
}
