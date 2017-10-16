
public interface Stack<T>
{
	
	public void push(T x);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public void makeEmpty();
}
