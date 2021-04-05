import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sort By Queue Button
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class SortByQueue extends MyButton
{
    /**
     * Constructs a sort by queue button
     */
    public SortByQueue() {
        super("Sort By Queue"); // Displays "Sort By Queue" on button
    }
    
    /**
     * Sorts rides according to line size
     */
    public void performAction() {
       ((MyWorld)getWorld()).sortBySize();
    }
}
