import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sort By Name Button
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class SortByName extends MyButton
{
    /**
     * Constructs a sort by name button
     */
    public SortByName() {
        super("Sort By Name"); // Displays "Sort By Name" on the button
    }
    
    /**
     * Sorts rides lexicographically according to name
     */
    public void performAction() {
        ((MyWorld)getWorld()).sortByName();
    }
}
