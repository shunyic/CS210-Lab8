interface NodeFunctions
{
	public int getKey();
	public Node getParent();
	public Node getLeft();
	public Node getRight();
	public int getCount();
	public void setLeft(Node n);
	public void setRight(Node n);
	public void setParent(Node n);
	public void setCount(int count);
	public String toString();
	public boolean equals(Object o);
	public int hashCode();
}