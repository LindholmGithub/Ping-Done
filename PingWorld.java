import greenfoot.*;


/**
 * The PingWorld is where Balls and Paddles meet to play pong.
 * 
 * @author The Best Group
 * @version 1
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;

    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        if (gameStarted)
        {
            GreenfootImage background = getBackground();
            background.setColor(Color.BLACK);
            background.fill();
            addObject(new ScoreBoard(),80,20);
            addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
            addObject(new Paddle(100,20), 60, 60);
            addObject(new Player(100,20), 60, WORLD_HEIGHT-60);
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }
}
