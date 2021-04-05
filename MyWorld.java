import greenfoot.*;         // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.FileDialog; // Imports File Dialog From Java API
import java.util.Scanner;   // Imports scanner from Java API
import java.io.*;           // Imports java.io class from Java API

/**
 * Amusement Park
 * 
 * @author Jake Campbell
 * @version 04/29/2018
 */
public class MyWorld extends World
{
    private Ride[] rides; // Array of rides in the world
    private int numRides; // Number of rides in the world
    private String name;  // Name of the ride
    
    public static final int MAX_RIDES=14;  // Maximum number of rides possible

    /**
     * Constructs world of 800x600 pixels, and places "Load" button, a "Merge"
     * button, a "Sort By Name" button, and a "Sort By Queue" button across
     * the top of the world
     */
    public MyWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // Initializes array of rides, sets the number of rides to zero, sets the
        // sets variable "name" to null
        rides = new Ride[14];
        numRides = 0;
        name = null;

        // Adds a "Load" button to the top of the world
        Load loadButton = new Load();
        this.addObject(loadButton, 100, 30);
        
        // Adds a "Merge" button to the top of the world
        Merge mergeButton = new Merge();
        this.addObject(mergeButton, 300, 30);
        
        // Adds a "Sort By Name" button to the top of the world
        SortByName sortByNameButton = new SortByName();
        this.addObject(sortByNameButton, 500, 30);
        
        // Adds a "Sort By Queue" button to the top of the world
        SortByQueue sortByQueueButton = new SortByQueue();
        this.addObject(sortByQueueButton, 700, 30);
    }
    
    // Removes all rides from the world
    private void removeAllRides() {
        removeObjects(getObjects(Ride.class));
    }
    
    // Removes all people from the world
    private void removeAllPeople() {
        removeObjects(getObjects(Person.class));
    }
    
    // Removes all "Add" buttons from the world
    private void removeAllAddButtons() {
        removeObjects(getObjects(Add.class));
    }
    
    // Removes all "Release" buttons from the world
    private void removeAllReleaseButtons() {
        removeObjects(getObjects(Release.class));
    }
    
    // Removes all ride names from the world
    private void removeAllNames() {
        removeObjects(getObjects(RideName.class));
    }
   
    /**
     * Removes all current rides, buttons, and people from the world 
     * before adding more rides from a user selected data file
     */
    public void loadRides() {
        // Removes all rides, buttons, and people
        removeAllRides();
        removeAllPeople();
        removeAllAddButtons();
        removeAllReleaseButtons();
        removeAllNames();
        
        // Shows user a file directory
        FileDialog fd = null;
        fd = new FileDialog(fd, "Choose a File to Import Rides", FileDialog.LOAD);
        fd.setVisible(true);
           
        // Gets the name of the selcted file
        String where = fd.getDirectory();
        String what = fd.getFile();
        String fileName = where + what;
           
        // Stores the selected file in a variable of type "File"
        File myFile = new File(fileName);
        
        // Tries the selected file in a scanner
        Scanner dataReader = null;  
        try {
            dataReader = new Scanner(myFile);
        }
        // Catches "FileNotFoundException" error and returns method if no file was selected
        catch(FileNotFoundException fnfe) {
            System.out.println("Could not open file" + fileName);
            return;
        }
   
        
        numRides = 0; // Resets "numRides" to zero
        
        // Adds new rides according to data from user selected file
        while(dataReader.hasNext()) {
            name = dataReader.nextLine(); // Stores line of data file into variable "name"
            
            // If "numRides" is less than the length of the array, creates new ride in 
            // array with most recent data stores in "name", adds the new ride to the
            // world, and increments "numRides" by one
             if(numRides < rides.length) {
                rides[numRides] = new Ride(name);
                addObject(rides[numRides], 550, 75 + 37*numRides);
                numRides++;
            }
        }
        
        dataReader.close(); // Closes scanner

    }
    
    public void mergeRides() {
        // Shows user a file directory
        FileDialog fd = null;
        fd = new FileDialog(fd, "Choose a File to Import Rides", FileDialog.LOAD);
        fd.setVisible(true);
           
        // Gets the name of the selcted file
        String where = fd.getDirectory();
        String what = fd.getFile();
        String fileName = where + what;
            
        // Stores the selected file in a variable of type "File"
        File myFile = new File(fileName);
        
        // Tries the selected file in a scanner
        Scanner dataReader = null;    
        try {
            dataReader = new Scanner(myFile);
        }
        // Catches "FileNotFoundException" error and returns method if no file was selected
        catch(FileNotFoundException fnfe) {
            System.out.println("Could not open file" + fileName);
            return;
        }
   
        // Adds new rides according to data from user selected file
        while(dataReader.hasNext()) {
            name = dataReader.nextLine(); // Stores line of data file into variable "name"
            
            // If "numRides" is less than the length of the array, adds new ride to the end of
            // the array with most recent data stores in "name", adds the new ride to the
            // world, and increments "numRides" by one
            if(numRides < rides.length) {
                rides[numRides] = new Ride(name);
                addObject(rides[numRides], 550, 75 + 37*numRides);
                numRides++;
            }
        }
        
        dataReader.close(); // Closes scanner
    }
    
    /**
     * Sorts rides lexicographically according to their name
     */
    public void sortByName() {
        boolean swapDone; // Creates a new variable "swapDone" of type boolean
        
        // Run this segment of code at least one time
        do {
            swapDone = false; // Sets "swapDone" to false
            
            // For each index of the array "rides"...
            for(int index = 0; index < numRides - 1; ++index) {
                String name = rides[index].getName();             // Gets name at "index"
                String namePlusOne = rides[index + 1].getName() ; // Gets name at "index" plus one
                
                // If "name" compared to "namePlusOne" is greater than zero...
                if(name.compareTo(namePlusOne) > 0) {
                    Ride temp = rides[index];        // Creates variable "temp" of type Ride at "index"
                    rides[index] = rides[index + 1]; // Moves name at "index" to "index" plus one
                    rides[index + 1] = temp;         // Moves name at "index" plus one to "temp"
                    swapDone = true;                 // Sets "swapDone" to true
                }
            }
        }
        while(swapDone); // Do this while swaps are still being made
        
        redrawArray(); // Redraw the contents of the array
    }
    
    /**
     * Sorts rides according to number or people in line
     */
    public void sortBySize() {
        boolean swapDone;// Creates a new variable "swapDone" of type boolean
        
        // Run this segment of code at least one time
        do {
            swapDone = false; // Sets "swapDone" to false
            
            // For each index of the array "rides"...
            for(int index = 0; index < numRides - 1; index++) {
                
                // If the size of the line at "index" is less that the size of the line
                // at "index" plus one...
                if(rides[index].getSize() < rides[index + 1].getSize()) {
                    Ride temp = rides[index];        // Creates variable "temp" of type Ride at "index"
                    rides[index] = rides[index + 1]; // Moves name at "index" to "index" plus one
                    rides[index + 1] = temp;         // Moves name at "index" plus one to "temp"
                    swapDone = true;                 // Sets "swapDone" to true
                }
            }
        }
        while(swapDone); // Do this while swaps are still being made
         
        redrawArray(); // Redraw the contents of the array
     }
      
    /**
     * Redraws the contents of the array
     */
    private void redrawArray() {
        // For each index of the array "rides"...
        for(int index = 0; index < numRides; index++) {
            rides[index].moveTo(550, 75 + 37*index); // Move this object to the apppropriate position
        }
    }
}
