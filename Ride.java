import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics2D;
/**
 * Ride Line
 * 
 * @author Jake Campbell
 * @version 04/29/2019
 */
public class Ride extends Actor
{
    private Person[] rideLine; // Array of people in ride line
    private int numPerson;     // Number of poeple in ride line
    private int increment;     // Increment X coordinate of people in ride line
    private String name;       // Name of ride       
    
    private Add addButton;         // Add Button
    private Release releaseButton; // Release Button
    private RideName rideName;     // Ride Name
    
    /**
     * Construct a new ride
     * 
     * @param name of this ride
     */
    public Ride(String name) {
        this.name = name;          // Initialize instance variable "name" as parameter
        
        rideLine = new Person[20]; // A ride can have no more than 20 people in line
        numPerson = 0;             // The ride currently has 0 people in line
        
        increment = 40;            // Initialize increment with a value of 40
    }
    
    /**
     * Once the ride has been added to the world...
     */
    protected void addedToWorld(World w) {
        // Create a new add button and add it to the world
        addButton = new Add(this);
        getWorld().addObject(addButton, getX(), getY());
       
        // Create a new release button and add it to the world
        releaseButton = new Release(this);
        getWorld().addObject(releaseButton, getX() + 50, getY());
        
        // Create new text containing the ride name and add it to the world
        rideName = new RideName(name);
        getWorld().addObject(rideName, getX() + 160, getY());
    }
   
    /**
     * Return the name of the ride
     */
    public String getName() {
        return name;
    }
    
    /**
     * Return the size of the ride line
     */
    public int getSize() {
        return numPerson;
    }
    
    /**
     * Move the ride and its associated objects to a new (X,Y) location
     * 
     * @param change X location
     * @param chance Y location
     */
    public void moveTo(int xLoc, int yLoc) {
        setLocation(xLoc, yLoc); // Set new ride location
        
        addButton.setLocation(addButton.getX(), getY());         // Set new add button location
        releaseButton.setLocation(releaseButton.getX(), getY()); // Set new release button location
        
        rideName.setLocation(rideName.getX(), getY()); // Set new ride name location
        
        increment = 40; // Reset increment to 40
        
        // For each person in the ride line...
        for(int i = 0; i < numPerson; i++) {
            rideLine[i].setLocation(addButton.getX() - increment, getY()); // Set new location
            increment += 25;                                               // Increase increment by 25
        }
        
    }
    
    /**
     * Add a new person to this ride line
     */
    public void addPerson() {
        Person person = new Person(); // Create a new person
        
        // If the number of people currently in the line is less than the length of the array...
        if(numPerson < rideLine.length) {
            rideLine[numPerson] = person;                             // Add a person to next available index
            getWorld().addObject(person, getX() - increment, getY()); // Add this person to the world
            increment += 25;                                          // Increase increment by 25
            numPerson++;                                              // Increment "numPerson" by one
        }
        // Else, return the method
        else {
            return;
        }
    }
   
    /**
     * Release an existing person from this ride line
     */
    public void releasePerson() {
        getWorld().removeObject(rideLine[0]); // Remove the person at smallest index from the world
        
        // If there is at least one person in the ride line///
        if(numPerson >= 1) {
           
           // For each person in the ride line...
            for(int index = 1; index < numPerson; index++) {
               rideLine[index - 1] = rideLine[index]; // Subtract one from their current index
               rideLine[index].move(25);              // Move each person 25 pixels to the right
           }
           increment -= 25; // Decrease increment by 25
           numPerson--;     // Decrement "numPerson" by one
        }
        // Else, return the method
        else {
            return;
        }
    }   
}
