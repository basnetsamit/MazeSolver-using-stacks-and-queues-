//Samit Basnet
//defines the functions of the stackagenda to solve the maze

import java.util.Stack;

public class StackAgenda extends Agenda
{
    Stack<GridLocation> stack=new Stack<GridLocation>();  //make a new stack that holds GridLocation
   
    public void addLocation(GridLocation loc) //adds the given location to the stack
    {
	stack.push(loc);
    }

    public GridLocation getLocation() //takes the location out of the stack and returns
    {
	return stack.pop();
    }

    public boolean isEmpty() //checks if the stack has any elements
    {
	return stack.empty();
    }


    public void clear() //empties the entire stack
    {
	while(stack.empty()!=true)
	    {
		stack.pop();
	    }
    }

    public String toString() //gives a string representation of what is in the stack
    {
	return stack.toString();
    }

    public int size() //gives the size of the stack
    {
	return stack.size();
    }
	

    public static void main(String[] args)
    {
	//tests for the stackagenda
	
	StackAgenda stackagenda=new StackAgenda();

	GridLocation aa=new GridLocation(2,3);
	GridLocation ab=new GridLocation(2,5);
	
	stackagenda.addLocation(aa);
	stackagenda.addLocation(ab);
	
	//System.out.println("size after adding"+stackagenda.size());
	System.out.println(stackagenda);

	//System.out.println(stackagenda.getLocation());
	stackagenda.clear();

	//System.out.println(stackagenda);

	
	System.out.println(stackagenda.isEmpty());

	System.out.println(stackagenda);
    }


}
