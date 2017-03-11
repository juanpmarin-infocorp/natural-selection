import greenfoot.*;

/**
 * Write a description of class Util here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Util  
{

    /**
     * Genera un número aleatorio inclusivo al rango entregado
     */
    public static int getRandomNumber(int min, int max)
    {
        return Greenfoot.getRandomNumber(max - min + 1) + min;
    }
}
