import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ScoreBoard is an object that displays, and keeps track of the game level.
 * 
 * @author The Best Group  
 * @version 1
 */
public class ScoreBoard extends Actor
{
    private GreenfootImage image;
    private int speed;
    /**
     * Act - do whatever the ScoreBoard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       speed = ((Ball) getWorld().getObjects(Ball.class).get(0)).getSpeed();
       setImage(new GreenfootImage("Game Level: " + (speed-1), 24, Color.GREEN, Color.BLACK));
    }
}
