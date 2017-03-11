/**
 * Write a description of class Keyset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeySet  
{
    
    private String up;
    private String down;
    private String left;
    private String right;
    
    
    public KeySet(String up, String down, String left, String right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    
    public String getUp() {
        return up;
    }
    
    public String getDown() {
        return down;
    }
    
    public String getLeft() {
        return left;
    }
    
    public String getRight() {
        return right;
    }
    
}
