import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * A sublcass of the Ball, this class contains code that enables a ball
 * to be moved around by the user and also devour balls that are smaller than it.
 * 
 * @author C. Brooks-Prenger, X. XXXXXX
 * @version v1.0 - Template
 */
public class Katamari extends Ball
{
    //Instance Constants
    
    //Instance Variables    
    private boolean debug=false;

    /**
     * Constructor for the Katamari ball
     */
    public Katamari() 
    {
        size = 5;
        ballColor = Color.RED;
        super.updateImage();  //See discussion of super and this in video
    }
    
    /**
     * Check to see if this ball is touching smaller balls
     * 
     * @return null if not touching, or the object reference of the biggest ball it is touching
     */
    Ball isTouchingSmaller() 
    {
        Ball smallestBall = null;
        List ballList = getIntersectingObjects(Ball.class);
        
        if(!ballList.isEmpty()){
            for(int i=0; i<ballList.size(); i++){
                Ball tempBall;
                tempBall = (Ball)ballList.get(i);
                
                if(tempBall.getSize() < smallestBall.getSize()){
                    smallestBall = tempBall;
                }
                
            }
        }
        return smallestBall;
    }    
    
    /**
     * "Roll up" another ball thereby removing it from the game and adding
     * it's size to the Katamari
     * 
     * @param Ball to be rolled up
     */
    private void absorb(Ball smallBall) {
        //Increase size of current ball
        size = size + smallBall.getSize();
        
        //Get the current world object
        Actor getBall = getOneIntersectingObject(Ball.class);
        
        //Remove the ball from the current world
        getWorld().removeObject(getBall);
        
        //update the image for the katamari so the visuals reflect it's new size
        super.updateImage();
        
    }
    
    
    /**
     * Act - do whatever the Katamari wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * The Katamari has some very simplistic movement so that the user can control it
     */
    public void act() 
    {
        //Turn the ball based on left or right key presses        
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX()-1, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX()+1, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()+1);
        }
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX(), getY()-1);
        }
        //Check to see if the Katamari is touching something smaller.  If it 
        // is then absorb the smaller ball
        if(isTouchingSmaller() != null){
            absorb(isTouchingSmaller());
        }
        
        //Check to see if the Katamari is touching something bigger, if so
        //move backwards, otherwise move forwards.
        /*...insert code here...*/ 
    }    
}
