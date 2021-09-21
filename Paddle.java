import greenfoot.*;


/**
 * A paddle is an object that goes forth, respawns and hits the ball.
 */
public class Paddle extends Actor
{
    private int width;
    private int height;
    private int dx;
    private static final int MAX_SPAWN_Y = 340;

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
        createImage();
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tryChangeDirection();
        setLocation(getX() + dx, getY());
    }    

    /**
     *  Changes our Paddles X value to 0, and the Y value to a random number between 0 and MAX_SPAWN_Y.
     */
    private void tryChangeDirection()
    {
        if (isAtEdge() == true)
        {
            this.setLocation(0,Greenfoot.getRandomNumber(MAX_SPAWN_Y));
        }
    }

    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        setImage("Paddle.png");
    }
}
