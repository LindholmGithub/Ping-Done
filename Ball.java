import greenfoot.*;


/**
 * A Ball is an object that bounces of the walls, ceiling, and the paddles.
 * 
 * @author The Best Group
 * @version 2
 */
public class Ball extends Actor
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;

    private int speed = 2;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    private int speedCounter = 0;
    private String gameLevel;
    private boolean touchedPlayerLast = false;
    private boolean touchedPaddleLast = false;
    
    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        createImage();
        init();
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage(BALL_SIZE,BALL_SIZE);
        setImage("Ball.png");
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        isTouchingAnything();
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            checkRestart();
        }
    }    
    private void isTouchingAnything()
    {
        if  (isTouching(Player.class) && touchedPlayerLast == false) 
        {
            GreenfootSound ballHit = new GreenfootSound("bounce.wav");
            ballHit.play();
            speedCounter = speedCounter + 1;
            touchedPlayerLast = true;
            touchedPaddleLast = false;
            if (speedCounter >= 10)
            {
                speed = speed + 1;
                speedCounter = 0;
            }
            if (! hasBouncedVertically)
            {
                revertVertically();
            }
            else
            {
                hasBouncedVertically = false;
            }
        }
        if  (isTouching(Paddle.class) && touchedPlayerLast == true) 
        {
                GreenfootSound ballHit = new GreenfootSound("bounce.wav");
                ballHit.play();
                speedCounter = speedCounter +1;
                touchedPaddleLast = true;
                touchedPlayerLast = false;
                if (speedCounter >= 10)
                {
                    speed = speed + 1;
                    speedCounter = 0;
                }
                if (! hasBouncedVertically)
                {
                    revertVertically();
                }
                else
                {
                    hasBouncedVertically = false;
                }
        }
    }
    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }
    
    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
                GreenfootSound wallHit = new GreenfootSound("bouncewall.wav");
                wallHit.play();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If touching the ceiling the ball is bouncing off.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                GreenfootSound wallHit = new GreenfootSound("bouncewall.wav");
                wallHit.play();
                touchedPlayerLast = false;
                
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }

    /**
     * Check to see if the ball should be restarted.
     * If touching the floor the ball is restarted in initial position and speed.
     */
    private void checkRestart()
    {
        if (isTouchingFloor())
        {
            init();
            GreenfootSound gameOverSound = new GreenfootSound("gameover.mp3");
            gameOverSound.play();
            GameOverWorld gameOverWorld = new GameOverWorld();
            Greenfoot.setWorld(gameOverWorld);
            Greenfoot.stop();
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
    public int getSpeed()
    {
        return speed;
    }
}
