//Samit Basnet
//stores the layout of the maze

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Maze
{
    private int numRows;
    private int numCols;

    private GridLocation[][] world;

    private GridLocation start;
    private GridLocation goal;
    private HashMap<GridLocation, String> world1;
    

      
    public Maze(String fileName) throws FileNotFoundException
    {
	//open the file entered by user
	File myFile=new File(fileName); 
	Scanner input=null;
	input=new Scanner(myFile);

	//read the word file
	String line= input.nextLine();
	
       	Scanner lineScanner=new Scanner(line);
	lineScanner.useDelimiter(" "); //break the first line
	
	numRows=lineScanner.nextInt(); //get the row number from first line
	numCols=lineScanner.nextInt(); //get the column number from first line

	world=new GridLocation[numRows][numCols];
	int i=0; //gives rows
	int j=0; //gives columns

	world1=new HashMap<GridLocation, String>(); //hashmap to store a location and the element in that location

	while(input.hasNextLine())
	    {
		line=input.nextLine();
		Scanner lineScanner1=new Scanner(line);
		lineScanner1.useDelimiter(""); //get each element of line
		j=0;
		while(lineScanner1.hasNext()) //assess each element
		    {
			String element=lineScanner1.next();
			GridLocation location=new GridLocation(i,j);
			world[i][j]=location; //assign the location to the world
			
			if(element.equals("#"))
			    {
				world1.put(world[i][j], "#"); //store the location as a key and the element as its value in the hashmap
								
			    }
			if(element.equals("."))
			    {
				world1.put(world[i][j], ".");
			    }
			if(element.equals("o"))
			    {
				start=location; //o is the start
				world1.put(world[i][j], "o");
				
			    }
			if(element.equals("*"))
			   {
			       goal=location; //* is the goal
			       world1.put(world[i][j], "*");
			   }
			j=j+1; //goes to next column
		    }
		i=i+1; //goes to next row
	    }
    }

    public int getNumRows() //returns number of rows
    {
	return numRows;
    }

    public int getNumCols() //returns number of columns
    {
	return numCols;
    }

    public GridLocation getStartLocation() //gives the location of start
    {
	return start;
    }

    public GridLocation getGoalLocation() //gives the location of goal
    {
	return goal;
    }

    public char getSquare(GridLocation loc) //get the element in the given location from the hashmap
    {
	GridLocation loca=getMazeLocation(loc);
	String s=world1.get(loca);
      	return s.charAt(0);
    }

    public GridLocation getMazeLocation(GridLocation loc) //get the gridlocation equivalent to the maze world for a given location
    {
	int row=loc.getRow();
	int col=loc.getColumn();
	return world[row][col]; //returns gridlocation for given loc which is in the world
    }

    public String toString()
    {
	String maze="";
	int i=0;
	while (i<numRows)
	    {
		int j=0;
		while(j<numCols)
		    {
			
			GridLocation pos=world[i][j];  //get every gridlocation from world
			
			maze=maze+world1.get(pos);  //get the item in that position and append to out string accumulator
			j=j+1;
		    }
		maze=maze+"\n";  //new line after every row
		i=i+1;
	    }

	return maze;
    }

    public boolean isValidLoc(int r, int c) //checks if the new location is out of boundary i.e. less than 0 or more than numRows/numCols and returns a boolean
    {
	if((r>=numRows)||(c>=numCols)||(r<0)||(c<0)) 
	   {	   
	       return false;
	   }
	   else
	       {
		   return true;
	       }
		 
	       
    }

    public static void main(String[] args) throws FileNotFoundException
    {
			
	Maze maze1=new Maze(args[0]); //user input for instantiation of maze
	System.out.println(maze1);
	
	
    }
    
    
    
}
