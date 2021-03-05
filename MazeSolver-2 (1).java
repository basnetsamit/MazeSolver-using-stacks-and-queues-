//Samit Basnet
//algorithm to solve the maze

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.ArrayList; 

class MazeSolver
{
    //Stack<GridLocation> moves=new Stack<GridLocation>();

    GridLocation current;
    
    //agenda to add the adjacent location
    Agenda moves;
   
    //arraylist to keep track to visited positions
    ArrayList<GridLocation> visited=new ArrayList<GridLocation>();

    //arraylist to keep track of added position and what it was added by
    ArrayList<GridLocation> added=new ArrayList<GridLocation>();
    ArrayList<GridLocation> addedby=new ArrayList<GridLocation>();

    //arraylist to keep track of path to the goal
    ArrayList<GridLocation> path=new ArrayList<GridLocation>();  //from goal to start(backwards)
    ArrayList<GridLocation> sortedpath=new ArrayList<GridLocation>();

    
    int row;
    int col;
    
    
    public  MazeSolver(Agenda plan)
    {

	moves=plan;  //stackagenda follows the given agenda
    }

    public ArrayList solveMaze(Maze maze, MazeGUI graphics) //important method that solves the maze
    {
	MazeGUI gui=graphics;


	moves.clear(); //empties the stack
	
	int row=maze.getNumRows();
	int col=maze.getNumCols();
	
	GridLocation start=maze.getStartLocation(); //start of maze
	GridLocation goal=maze.getGoalLocation();  //goal of maze

	moves.addLocation(start);  //add the start location to stackagenda

	//add start location to arraylist holding positions
	visited.add(start);
	added.add(start);
	addedby.add(start);

	current=start; //GridLocation current is start 

	while(!current.equals(goal)) //loop runs until current element is not the goal
	{

	    //removes start from stackagenda as it won't be a valid move 
	    if ( current.equals(start)){
		moves.clear();
	    }
	    
	    int currentrow=current.getRow();  //get the current row
	    int currentcol=current.getColumn();  //get the current column
	
	//gives the location in the North
	    if(maze.isValidLoc((currentrow-1),currentcol))  //checks if the new location is valid
	    {
		GridLocation loca=new GridLocation(currentrow-1,currentcol); //makes the GridLocation out of new column and row
		GridLocation location=maze.getMazeLocation(loca);  //gets the location equivalent in the maze world
		if(maze.getSquare(location)!='#'&& visited.contains(location)!=true) //doesnt add if it is a wall or a visited location
		    {
				
			moves.addLocation(location);  //adds the current location to moves stackagenda
			gui.addLocToAgenda(location);
			addedby.add(current); //adds the location that this new location was added by
			added.add(location); //adds the new location
		    }
	    }
	//gives the location in the South
	if(maze.isValidLoc((currentrow+1),currentcol))
	    {
		GridLocation loca=new GridLocation(currentrow+1,currentcol);
		GridLocation location=maze.getMazeLocation(loca);
		if(maze.getSquare(location)!='#'&&visited.contains(location)!=true)
		    {
		
			moves.addLocation(location);
			gui.addLocToAgenda(location);
			addedby.add(current);
			added.add(location);
		    }
	    }
	//gives the location in the East
	if(maze.isValidLoc(currentrow,currentcol+1))
	    {
		GridLocation loca=new GridLocation(currentrow,currentcol+1);
		GridLocation location=maze.getMazeLocation(loca);
		if(maze.getSquare(location)!='#'&&visited.contains(location)!=true)
		    {
		
			moves.addLocation(location);
			gui.addLocToAgenda(location);
			addedby.add(current);
			added.add(location);
		    }
	    }
	//gives the location in the West
	if(maze.isValidLoc(currentrow,currentcol-1))
	    {
		GridLocation loca=new GridLocation(currentrow,currentcol-1);
		GridLocation location=maze.getMazeLocation(loca);
		if(maze.getSquare(location)!='#'&&visited.contains(location)!=true)
		    {
		
			moves.addLocation(location);
			gui.addLocToAgenda(location);
			addedby.add(current);
			added.add(location);
		    }
	    }

	//gets a new current from the stackagenda moves of newly added valid moves
	if(moves.isEmpty())
	    {
		return path;
	    }
	
	current=moves.getLocation();
	gui.pause(1);
	gui.visitLoc(current);

	
	visited.add(current);  //adds this new location to visited arraylist
	}  //End of while loop

	
	//to track the path from goal to start
	GridLocation cur=goal; //give the goal location to cur
	path.add(goal);  //add the goal to path as it is from where we are starting to track back
	while (!cur.equals(start)) //tracks back until it reaches start location
	    {
		int idx=added.indexOf(cur); //gets index of current location
		path.add(addedby.get(idx)); //gets and adds the location cur was added by from addedby arraylist
		cur=addedby.get(idx); //change the cur to the addedby location
	    }


	
	for(int j=path.size()-1; j>=0;j--) //sorts the path from start to goal
	    {
		sortedpath.add(path.get(j));
		gui.addLocToPath(path.get(j));
	    }
	
	return sortedpath; //returns the sorted path	    
    }

    
    public static void main(String[] args) throws FileNotFoundException
    {
	Maze maze1=new Maze(args[0]); //give a new maze via user input
	String type = args[1]; 
	Agenda agenda = null;
	

	if(type.equals("s"))
	    {
		StackAgenda moves=new StackAgenda();
		agenda =moves;
	    }
	else if(type.equals("q"))
	    {
		QueueAgenda moves=new QueueAgenda();
		agenda=moves;
	    }
	else if(!type.equals("s")&&!type.equals("q"))
	    {
		System.out.println("Error! Please enter a valid entry.");
		System.exit(0);
	    }
	

	MazeSolver solver = new MazeSolver (agenda);
	MazeGUI mazeGraphics = new MazeGUI(maze1);
	System.out.println(solver.solveMaze(maze1, mazeGraphics)); 
	
    }
    
	
}
	
	
	
	
