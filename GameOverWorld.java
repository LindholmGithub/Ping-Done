import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOverWorld is where the game ends after the player lets the ball pass either by mistake, or by will.
 * 
 * @author The Best Group 
 * @version 1
 */
public class GameOverWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
          super(WORLD_WIDTH, WORLD_HEIGHT, 1);
          GreenfootImage background = getBackground();
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PingWorld(true));
        }
    }
}
