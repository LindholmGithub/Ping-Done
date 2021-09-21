import greenfoot.*;


/**
 * A Player is a player-controlled object, that bounces the ball back into the world.
 * 
 * @author The Best Group 
 * @version 2
 */
public class Player extends Actor
{
    private int width;
    private int height;
    private int Y_LOCATION = 680;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Player(int width, int height)
    {
        this.width = width;
        this.height = height;
        createImage();
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        playerMovement();
    }    


    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        setImage("Player.png");
    }
    public void playerMovement()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(this.getX()-2, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(this.getX()+2, getY());
        }
    }
    
}
