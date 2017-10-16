
public class QueueLL<T> implements Queue<T>
{
	private class node
	{
		T data;
		node next;
	}
	
	private node front,back;
	private int count;
	
	public QueueLL()
	{
		makeEmpty();
	}
	
	public void enqueue(T x) 
	{
		node n = new node();
		n.data=x;
		n.next=null;
		if(back!=null)
		{
			back.next=n;
		}
		else
		{
			front=n;
		}
		back = n;
		count++;
	}

	public T dequeue() 
	{
		if(isEmpty())
		{
			return null;
		}
		
		T toReturn = front.data;
		front=front.next;
		if(front==null)
		{
			back=null;
		}
		count--;
		return toReturn;
	}

	public T peek() 
	{
		return (isEmpty())? null : front.data;
	}

	public boolean isEmpty() 
	{
		return count<=0;
	}

	public boolean isFull() 
	{
		return false;
	}

	public int size() 
	{
		return count;
	}

	public void makeEmpty() 
	{
		front=back=null;
		count=0;
	}

}
