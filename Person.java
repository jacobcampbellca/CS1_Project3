import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Person In Line
 * 
 * @author Jake Campbell 
 * @version 04/29/2018
 */
public class Person extends Actor
{
    private int callsInLine; // How long has this person been in line?
    
    /**
     * Constructs a person
     */
    public Person() {
        callsInLine = 0; // When initialized, a person has been in line for zero calls
    }
    
    /**
     * Determine how long the person has been in line, and 
     * display this number when a person is clicked
     */
    public void act() 
    {
        callsInLine++;                // Increment "callsInLine" by one
        int time = callsInLine / 100; // Divide "callsInLine" by 100, and store value in variable "time"
        String display = "" + time;   // Convert "time" from int to String, and store in variable "display"
       
        // If this person is clicked...
        if(Greenfoot.mouseClicked(this)) {
            ToolTip toolTip = new ToolTip(display);        // Create a new ToolTip with String "display"
            getWorld().addObject(toolTip, getX(), getY()); // Add ToolTip to the world at this (X,Y) location
        }
    }    
}
