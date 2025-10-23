public class BinarySearchTree implements BinarySearchTreeFunctions
{
	private Node root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public Node getRoot()
	{
		return null;
	}
	
	public void setRoot(Node root)
	{
	}
		
	public void insertNode(Node z)
	{
	}
	
	public void preOrderWalk(Node x)
	{
		if( x != null )
		{
			System.out.println(x.toString());
			preOrderWalk(x.getLeft());
			preOrderWalk(x.getRight());
		}
	}
	
	public void preOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			list.add(x.toString());
			preOrderWalk(x.getLeft(), list);
			preOrderWalk(x.getRight(), list);
		}
	}
	
	public void preOrderWalk(Node x, String id, java.util.ArrayList<String> result)
	{
		if( x != null )
		{
			System.out.println(x.toString() + " " + id);
			result.add(x.getKey() + " " + id);
			preOrderWalk(x.getLeft(), "0"+id, result);
			preOrderWalk(x.getRight(), "1"+id, result);
		}
	}
	
	public void inOrderWalk(Node x)
	{
	}
	
	public void inOrderWalk(Node x, java.util.ArrayList<String> list)
	{
	}
	
	public void postOrderWalk(Node x)
	{
	}
	
	public void postOrderWalk(Node x, java.util.ArrayList<String> list)
	{
	}
		
	public Node getMax(Node x)
	{
		return null; 
	}
	
	public Node getMin(Node x)
	{
		return null; 
	}
	
	public Node getSuccessor(Node x)
	{
		return null;
	}
	
	public Node getPredecessor(Node x)
	{
		return null;
	}
	
	public Node getNode(Node x, int key)
	{
		return null;
	}
	
	public int getHeight(Node x)
	{
		return 0;
	}
	
	public void shiftNode(Node u, Node v)
	{
	}
	
	public void deleteNode(Node z)
	{
	}
}
