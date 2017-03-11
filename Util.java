import greenfoot.*;

/**
 * Write a description of class Util here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util  
{
    
    public static int getRandomNumber(int min, int max)
    {
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }  
    
    public static Color randomColor(int min, int max) {
        return new Color(
                Util.getRandomNumber(min, max),
                Util.getRandomNumber(min, max),
                Util.getRandomNumber(min, max),
                Util.getRandomNumber(min, max));
    }
    
}
