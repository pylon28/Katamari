import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This is a world with a bunch of different sized things for you to "roll up"
 * 
 * This assignment is to get you familar with workin in an OO environment and 
 * to get you used to accessing and using java documentation.  Below are two
 * useful links that will help you.
 * 
 * Greenfoot Javadoc:  https://www.greenfoot.org/files/javadoc/
 * Java 11 List Javadoc : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/List.html
 * 
 * I also talk about access control in the video and you might find this page
 * interesting to check out if you want to know more about different java
 * class types : https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * 
 * @author C. Brooks-Prenger, X. XXXXXX
 * @version v1.0 - Template
 */
public class KatamriWorld extends World
{
    //Class Constants
    
    /* Note: 
     * Since these variables are definied at STATIC they will never change (aka are constant).
     * Normally when we have constant variables like this we name them in ALL CAPS
    */
    
    private static int MAXSIZE = 75; //Maximum Size for Object in the World
    private static int NUMSTARTTHINGS = 50; //Number of Balls to spawn at start
    private static int KATAMARISTARTSIZE = 15; //Size to start Katamari at
    
    //Instance Variables    
    private boolean debug=true;  //Turn on to enable extra debugging statements
    
    /**
     * Constructor for objects of class KatamariWorld.
     * 
     */
    public KatamriWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); //Please do not make this bigger, I mark on a laptop screen
        int randomX = Greenfoot.getRandomNumber(600);
        int randomY = Greenfoot.getRandomNumber(400);
        addObject(new Ball(50,randomX,randomY), randomX, randomY);
        //Populate the world with the starting number of balls
        for (int i=0;i<NUMSTARTTHINGS;i++)
        {
           placeRandomBall();   //This is the simple way
           // while (!placeRandomBall()) break;  //This is how I would actually do it
        }
        
        //Ensure that the balls are not overlapping each other
        boolean allBallsReady;
        Ball tempBall;

        do { 
            allBallsReady = true;
            //Get a List of all the balls all the balls
            List ballList = getObjects(Ball.class);
            if (debug) System.out.println(ballList);
            
            //Loop through entire list of balls
            for (int i=0; i<ballList.size(); i++) {
    
                //Get a single ball from the list
                tempBall = (Ball)ballList.get(i); //Error Discussion - Incompatible Types: java.lang.Object can't be converted to Ball
                //Ask the ball to get ready, if not ready, set allBallsReady to false
                if (!tempBall.getReady()) {
                    allBallsReady = false;
                }
            }
            
        }while (!allBallsReady); //Repeat until all of the balls report they are ready
        
        //Add the Katamari to the world so we have a playable "Character"
        placeRandomKatamari();
    }
    
    /**
     * Place a ball on a random location on the board
     * 
     * @return Returns true if successful, false if not successful
     */
    private boolean placeRandomBall()
    {
        //Get a random location and size for the ball to be placed
        int randX = Greenfoot.getRandomNumber(600);/*...insert code here... Hint check out the Greenfoot Class*/;
        int randY = Greenfoot.getRandomNumber(400);
        int randSize = Greenfoot.getRandomNumber(MAXSIZE);
        
        //Test to see if this location is already in use.  See video for explantion
        if (getObjectsAt(randX,randY,Ball.class).isEmpty()) {
            //Add a ball to the world
            
            addObject (new Ball(randSize,randX,randY),randX,randY);
            //Successfully complete task so return true
            return true;
        }
        
        //Something went wrong, so return a false value
        return false;
    }
    
    /**
     * Place a Katamari on a random location on the board
     * 
     * @return Returns true if successful, false if not successful
     */
    private boolean placeRandomKatamari()
    {
        //Get a random value for x and y to place the katamari at.
        int randX = Greenfoot.getRandomNumber(600);
        int randY = Greenfoot.getRandomNumber(400);
        
        if(getObjectsAt(randX, randY, Ball.class).isEmpty()){
            
            
            addObject(new Ball(KATAMARISTARTSIZE,randX,randY), randX, randY);
        //Place the ball into the world
            return true;
        }
    
        return false;
    }
}
