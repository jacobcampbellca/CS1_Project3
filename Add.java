import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Add Button
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class Add extends MyButton
{
    private Ride thisRide; // Ride containing this add button
    
    /**
     * Constructs an add button
     * 
     * @param the ride connected to this add button
     */
    public Add(Ride connectedButton) {
        super("Add"); // Display "Add" on button
        
        thisRide = connectedButton; // Connect this button to the appropriate ride
    }
  
    /**
     * Add a person to this ride line
     */
    public void performAction() {
        thisRide.addPerson();
    }
}
