import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ride Names
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class RideName extends Actor
{
    /**
     * Constructor to display text of ride name's
     * 
     * @param the name of the ride
     */
    public RideName(String name) {
        // Get the current image
        GreenfootImage img = new GreenfootImage(200, 30);
        
        // Drar all text in red
        img.setColor(Color.RED);
        
        // Build an appropriate sized font and use it
        Font font = new Font(12);
        img.setFont(font);
        
        // Draw names into image
        img.drawString(name, 30, 20);
        
        // Set the image to represent the name
        setImage(img);
    }
}
