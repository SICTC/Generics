
public class StackLL<T> implements Stack<T> 
{
	private class node
	{
		T data;
		node next;
	}
	
	private node top;
	private int count;
	
	
	public void push(T x) 
	{
		node n = new node();
		n.data = x;
		n.next = top;
		top = n;
		count++;
	}

	public T pop() 
	{
		if(isEmpty())
		{
			return null;
		}
		T toReturn = top.data;
		top=top.next;
		count--;
		return toReturn;
	}

	
	public T peek() 
	{
		return (isEmpty())? null : top.data;
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
		top=null;
		count=0;
	}

}
