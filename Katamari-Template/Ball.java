import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * A ball that populates the world.
 * 
 * @author C. Brooks-Prenger, X. XXXXXX
 * @version v1.0 - Template
 */
public class Ball extends Actor
{
    //Instance Constants

    //Instance Variables    
    int size = 20;
    int ballX;
    int ballY;
    Color ballColor;
    private boolean debug=false;
    private boolean readyToStart=false;

    /**
     * Constructor for objects of class Ball.
     * If no input parameters are specified it defaults to ball size of 20
     */
    public Ball() 
    {
        this(20,0,0);
    }// End Constructor

    /***
     * Constructor for objects of class Ball.
     * 
     * @param sizeIn The size of the ball to create
     */
    public Ball(int sizeIn,int x, int y) 
    {
        size = sizeIn+1;
        ballColor = Color.CYAN;
        updateImage();
        readyToStart =false;
        
        ballX = x;
        ballY = y;
    }//End Constructor

    /**
     * Returns the size of the ball
     * 
     * @return size the size of the ball
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks to see if the ball is touching a ball bigger than it. If it is
     * touching another ball it repositions itself.
     * 
     * @return true if ready, false if reposition was required
     */
    public boolean getReady() {
        readyToStart = false;
        
        //Check to see if ball is touching something bigger and save result
        /*...insert code here...*/
        
        //If touching result is not null, then move away from the ball it is touching
        if(isTouchingBigger()!= null){
            moveAway(isTouchingBigger());
        }
        
        //else we are ready to start
        else {
            readyToStart = true;
        }

        return readyToStart;
    }

    /**
     * Update the image to be displayed on the screen for the Ball object
     * 
     */
    void updateImage()
    {
        //Create an image of the set size using built in greenfoot commands
        GreenfootImage displayImage;
        displayImage=new GreenfootImage(size,size);

        //Draw Circle
        displayImage.setColor(ballColor); //Set color to ballColor
        displayImage.drawOval(ballX, ballY, size, size);//Draw a circle

        //Display the number inside circle
        Font displayFont = new Font( (int)(size*0.75) );
        displayImage.setColor(Color.BLACK); //Set color to Black
        displayImage.setFont(displayFont);
        displayImage.drawString(Integer.toString(size),(int)(size*0.1),(int)(size*0.8));
        //Add the image as the new image for this object
        setImage(displayImage);

    }

    /**
     * Check to see if the Ball is touching another ball that is bigger than it
     * 
     * @return null if not touching, or the object reference of the biggest ball it is touching
     */
    Ball isTouchingBigger() 
    {
        //Get list of all Objects that are intersecting this one
        List ballList = getIntersectingObjects(Ball.class); 
        //Create a variable to store the biggest ball intersecting
        Ball biggestBall=null;
        if (debug) System.out.println(ballList);
        
        //Check to see if list is empty (ie, no intersections)
        if (!ballList.isEmpty()) {
            

            //Iterate through the list and find the biggest ball it is touching.
            for(int i=0;i<ballList.size();i++){            
                //Get a single ball from the list
                Ball tempBall;
                tempBall = (Ball)ballList.get(i);  //Note, I have to do a cast conversion here to tell Java to expect a specific object type
                //Check the size of the ball and save if needed
                //if(tempBall.getSize() > biggestBall.getSize()){
                //    biggestBall = tempBall;
                //}    
            }
            

        }

        //Return the correct value as specfied in javadoc at start of method
        return biggestBall;

    }

    
    /**
     * Move away from the specified ball so that they no longer intersect.
     * 
     * @param The ball to be moving away from
     */
    void moveAway(Ball runFromThis) {
        if (debug) System.out.println(this + " is runing from " + runFromThis);
        
        runFromThis.move(1);
        
        
    }

    /**
     * Act - do whatever the ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Currently the balls don't do any regular actions so we can leave this blank.

    } 

}
