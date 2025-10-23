public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	private int count;
	
	public Node(int key)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
		count = 0;
	}
		
	public int getKey()
	{
		return 0;
	}
	
	public Node getParent()
	{
		return null;
	}
	
	public Node getLeft()
	{
		return null;
	}
	
	public Node getRight()
	{
		return null;
	}
	
	public void setLeft(Node n)
	{
	}
	
	public void setRight(Node n)
	{
	}
	
	public void setParent(Node n)
	{
	}
	
	public String toString()
	{
		return "";
	}
	
	public boolean equals(Object o)
	{
		return false;
	}
	
	public int getCount()
	{
		return 0;
	}
	
	public void setCount(int count)
	{
	}
	
	public int hashCode()
	{
		return 0;
	}
}
