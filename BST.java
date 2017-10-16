
public class BST<K extends Comparable<K>,V>
{
	private class node
	{
		K key;
		V value;
		node left,right;
	}
	
	private node root;
	private int count;
	private V removedThing;
	private Queue<V> Q;
	
	public static final int PRE=-1;
	public static final int IN=0;
	public static final int POST=1;
	
	public BST()
	{
		makeEmpty();
		Q = new QueueLL<V>();
	}
	
	private node insert(K k, V v, node n)
	{
		if(n==null) //found where we're inserting to
		{
			node t = new node();
			t.key = k;
			t.value = v;
			t.left=t.right=null;
			return t;
		}
		if(k.compareTo(n.key) < 0) //insert into left branch
		{
			n.left=insert(k,v,n.left);
		}
		else //insert into right branch
		{
			n.right=insert(k,v,n.right);
		}
		return n;
	}
	
	public void insert(K k, V v)
	{
		root=insert(k,v,root);
		count++;
	}
	
	private V lookup(K k, node n)
	{
		if(n==null)
		{
			return null;
		}
		if(k.compareTo(n.key)==0) //found it!
		{
			return n.value;
		}
		if(k.compareTo(n.key)<0) //search left child
		{
			return lookup(k,n.left);
		}
		else //search right child
		{
			return lookup(k,n.right);
		}
	}
	
	public V lookup(K k)
	{
		return lookup(k,root);
	}
	
	private node remove(K k, node n)
	{
		if(n==null)
		{
			return null;
		}
		
		if(k.compareTo(n.key)==0)
		{
			//3 cases
			//0 children:
			if(n.left == null && n.right == null)
			{
				removedThing = n.value;
				count--;
				return null;
			}
			//1 child:
			if(n.left == null)
			{
				removedThing = n.value;
				count--;
				return n.right;
			}
			if(n.right==null)
			{
				removedThing = n.value;
				count--;
				return n.left;
			}
			//2 children:
			node min = min(n.right);
			V saved = n.value;
			n=min;
			n.right=remove(min.key,n.right);
			removedThing=saved;
			return n;
		}
		if(k.compareTo(n.key)<0) //search left branch
		{
			n.left=remove(k,n.left);
		}
		else //search right branch
		{
			n.right=remove(k,n.right);
		}
		
		return n;
	}
	
	private node min(node n)
	{
		if(n==null)
		{
			return null;
		}
		if(n.left==null)
		{
			return n;
		}
		else
		{
			return min(n.left);
		}
	}
	
	public V remove(K k)
	{
		removedThing=null;
		root=remove(k,root);
		return removedThing;
	}
	
	private void traverse(node n, int order)
	{
		if(n==null)
		{
			return; //do nothing
		}
		
		if(order==PRE)
		{
			Q.enqueue(n.value);
		}
		
		traverse(n.left,order); //traverse left child
		
		if(order==IN)
		{
			Q.enqueue(n.value);
		}
		
		traverse(n.right,order); //traverse right child
		
		if(order==POST)
		{
			Q.enqueue(n.value);
		}
	}
	
	public void reset(int order)
	{
		Q.makeEmpty();
		traverse(root,order);
	}
	
	public V getNext()
	{
		return Q.dequeue();
	}
	
	public V peekNext()
	{
		return Q.peek();
	}
	
	public boolean hasNext()
	{
		return !Q.isEmpty();
	}
	
	public void makeEmpty()
	{
		root=null;
		count=0;
	}
}
