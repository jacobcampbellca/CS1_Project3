import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Release Button
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class Release extends MyButton
{
    private Ride thisRide; // Ride containing this release button
    
    /**
     * Constructs a release button
     * 
     * @param the ride connected to this add button
     */
    public Release(Ride connectedButton) {
        super("Release"); // Displays "Release" on button
        
        thisRide = connectedButton; // Connect this button to the appropriate ride
    }
    
    /**
     * Release a person from this ride line
     */
    public void performAction() {
        thisRide.releasePerson();
    }
}
