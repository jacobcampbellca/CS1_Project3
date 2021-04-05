import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Merge Button
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class Merge extends MyButton
{
    /**
     * Constructs a merge button
     */
    public Merge() {
        super("Merge"); // Displays "Merge" on the button
    }  
    
    /**
     * Merge rides with existing rides in the world
     */
    public void performAction() {
        ((MyWorld)getWorld()).mergeRides();
    }
}
