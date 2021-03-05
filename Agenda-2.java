//Samit Basnet
//abstract file for StackAgenda
//StackAgenda should implement all these methods with the same return type


public abstract class Agenda
{
    
    public abstract void addLocation(GridLocation loc);
    

	public abstract GridLocation getLocation();
   

	public abstract boolean isEmpty();
   

	public abstract void clear();
    

	public abstract String toString();
    


}

