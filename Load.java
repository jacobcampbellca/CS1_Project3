import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Load Button
 * 
 * @author Jake Campbell 
 * @version 04/29/2018
 */
public class Load extends MyButton
{
    /**
     * Constructs a load button
     */
    public Load() {
        super("Load"); // Display "Load" on button
    }

    /**
     * Load rides into the world
     */
    public void performAction() {
        ((MyWorld)getWorld()).loadRides();
    }
}
