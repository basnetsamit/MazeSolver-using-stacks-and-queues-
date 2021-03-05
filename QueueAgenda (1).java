//Samit Basnet
//defines the functions of the queueagenda to solve the maze

import java.util.ArrayDeque;

public class QueueAgenda extends Agenda
{
    //new queue to hold gridlocations
    ArrayDeque<GridLocation> queue=new ArrayDeque<GridLocation>();

    public void addLocation(GridLocation loc) //adds the location to queue
    {
	queue.add(loc);
    }

    public GridLocation getLocation() //removes and returns first location from queue
    {
	return queue.removeFirst();
    }

    public boolean isEmpty() //checks if queue is empty
    {
	return queue.isEmpty();
    }

    public void clear() //empties the entire queue
    {
	while(queue.isEmpty()!=true)
	    {
		queue.removeFirst();
	    }
    }

    public String toString() //string representation of contents of queue
    {
	return queue.toString();
    }

    public int size() //returns the size of the queue
    {
	return queue.size();
    }

    public static void main(String[] args)
    {
	//test for the queueagenda

	QueueAgenda q=new QueueAgenda();

	GridLocation aa=new GridLocation(2,3);
	GridLocation ab=new GridLocation(2,5);
	GridLocation ac=new GridLocation(5,2);
	GridLocation ad=new GridLocation(3,5);

	q.addLocation(aa);
	q.addLocation(ab);
	q.addLocation(ac);
	q.addLocation(ad);

	System.out.println(q);

	//	q.clear();

	q.getLocation();

		System.out.println(q);

		
		q.getLocation();
	

		///System.out.println(q.isEmpty());

		//q.getLocation();

		//	System.out.println(q.isEmpty());

			System.out.println(q);
	
	
	
    }
}
	    
    
				 
				
