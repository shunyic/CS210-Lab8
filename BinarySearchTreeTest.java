import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import apple.laf.JRSUIUtils.Tree;

class BinarySearchTreeTest 
{
	// use this binary search tree for the smaller trees
	BinarySearchTree tree;
	
	// use this binary search tree for the 31 key tree
	BinarySearchTree t;
	
	// test node 20 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertRoot;
	static String[] checkInOrderWalkInsertRootArray;
	
	// test nodes 20 and 10 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertTwoNodes;
	static String[] checkInOrderWalkInsertTwoNodesArray;
	
	// test nodes 20 and 30 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertTwoNodesB;
	static String[] checkInOrderWalkInsertTwoNodesBArray;
		
	// test nodes 20, 10, 30 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertThreeNodes;
	static String[] checkInOrderWalkInsertThreeNodesArray;
	
	// test nodes 20, 10, 30, 5, 15, 25, 35 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertSevenNodes;
	static String[] checkInOrderWalkInsertSevenNodesArray;
	
	// test nodes 50, 25, 75, 15, 40, 60, 90, 10, 20, 30, 45, 55, 
	// 70, 80, 95, 8, 12, 28, 4, 9, 11, 13, 27, 29, 53, 57, 54, 56, 
	// 58, 93, 91 added correctly
	static java.util.ArrayList<String> checkInOrderWalkInsertThirtyOneNodes;
	static String[] checkInOrderWalkInsertThirtyOneNodesArray;
	
	// delete node 45 from the 31 node bst
	static java.util.ArrayList<String> checkInOrderWalkPostDelete45;
	static String[] checkInOrderWalkPostDelete45Array;
	
	// delete nodes 45 and 95 from the 31 node bst
	static java.util.ArrayList<String> checkInOrderWalkPostDelete45And95;
	static String[] checkInOrderWalkPostDelete45And95Array;
	
	// delete nodes 45, 95, and 60 from the 31 node bst
	static java.util.ArrayList<String> checkInOrderWalkPostDelete45And95And60;
	static String[] checkInOrderWalkPostDelete45And95And60Array;
	
	// delete nodes 45, 95, 60, and 50 from the 31 node bst
	static java.util.ArrayList<String> checkInOrderWalkPostDelete45And95And60And50;
	static String[] checkInOrderWalkPostDelete45And95And60And50Array;

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		// expected result for adding one key
		checkInOrderWalkInsertRoot = new java.util.ArrayList<>();
		checkInOrderWalkInsertRoot.add("(20,,,,1)");
		checkInOrderWalkInsertRootArray = checkInOrderWalkInsertRoot.toArray(new String[0]);
		
		// expected result for adding two keys
		checkInOrderWalkInsertTwoNodes = new java.util.ArrayList<>();
		checkInOrderWalkInsertTwoNodes.add("(10,20,,,1)");
		checkInOrderWalkInsertTwoNodes.add("(20,,10,,1)");
		checkInOrderWalkInsertTwoNodesArray = checkInOrderWalkInsertTwoNodes.toArray(new String[0]);
		
		// expected result for adding two keys
		checkInOrderWalkInsertTwoNodesB = new java.util.ArrayList<>();
		checkInOrderWalkInsertTwoNodesB.add("(20,,,30,1)");
		checkInOrderWalkInsertTwoNodesB.add("(30,20,,,1)");
		checkInOrderWalkInsertTwoNodesBArray = checkInOrderWalkInsertTwoNodesB.toArray(new String[0]);
		
		// expected result for adding three keys
		checkInOrderWalkInsertThreeNodes = new java.util.ArrayList<>();
		checkInOrderWalkInsertThreeNodes.add("(10,20,,,1)");
		checkInOrderWalkInsertThreeNodes.add("(20,,10,30,1)");
		checkInOrderWalkInsertThreeNodes.add("(30,20,,,1)");
		checkInOrderWalkInsertThreeNodesArray = checkInOrderWalkInsertThreeNodes.toArray(new String[0]);
		
		// expected result for adding seven keys
		checkInOrderWalkInsertSevenNodes = new java.util.ArrayList<>();
		checkInOrderWalkInsertSevenNodes.add("(5,10,,,1)");
		checkInOrderWalkInsertSevenNodes.add("(10,20,5,15,1)");
		checkInOrderWalkInsertSevenNodes.add("(15,10,,,1)");
		checkInOrderWalkInsertSevenNodes.add("(20,,10,30,1)");
		checkInOrderWalkInsertSevenNodes.add("(25,30,,,1)");
		checkInOrderWalkInsertSevenNodes.add("(30,20,25,35,1)");
		checkInOrderWalkInsertSevenNodes.add("(35,30,,,1)");
		checkInOrderWalkInsertSevenNodesArray = checkInOrderWalkInsertSevenNodes.toArray(new String[0]);
		
		// expected result for adding 31 keys
		checkInOrderWalkInsertThirtyOneNodes = new java.util.ArrayList<>();
		checkInOrderWalkInsertThirtyOneNodes.add("(4,8,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(8,10,4,9,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(9,8,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(10,15,8,12,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(11,12,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(12,10,11,13,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(13,12,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(15,25,10,20,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(20,15,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(25,50,15,40,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(27,28,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(28,30,27,29,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(29,28,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(30,40,28,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(40,25,30,45,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(45,40,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(50,,25,75,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(53,55,,54,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(54,53,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(55,60,53,57,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(56,57,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(57,55,56,58,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(58,57,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(60,75,55,70,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(70,60,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(75,50,60,90,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(80,90,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(90,75,80,95,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(91,93,,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(93,95,91,,1)");
		checkInOrderWalkInsertThirtyOneNodes.add("(95,90,93,,1)");
		checkInOrderWalkInsertThirtyOneNodesArray = checkInOrderWalkInsertThirtyOneNodes.toArray(new String[0]);
		
		// expected result for adding 31 keys and deleting one  
		checkInOrderWalkPostDelete45 = new java.util.ArrayList<>();
		checkInOrderWalkPostDelete45.add("(4,8,,,1)");
		checkInOrderWalkPostDelete45.add("(8,10,4,9,1)");
		checkInOrderWalkPostDelete45.add("(9,8,,,1)");
		checkInOrderWalkPostDelete45.add("(10,15,8,12,1)");
		checkInOrderWalkPostDelete45.add("(11,12,,,1)");
		checkInOrderWalkPostDelete45.add("(12,10,11,13,1)");
		checkInOrderWalkPostDelete45.add("(13,12,,,1)");
		checkInOrderWalkPostDelete45.add("(15,25,10,20,1)");
		checkInOrderWalkPostDelete45.add("(20,15,,,1)");
		checkInOrderWalkPostDelete45.add("(25,50,15,40,1)");
		checkInOrderWalkPostDelete45.add("(27,28,,,1)");
		checkInOrderWalkPostDelete45.add("(28,30,27,29,1)");
		checkInOrderWalkPostDelete45.add("(29,28,,,1)");
		checkInOrderWalkPostDelete45.add("(30,40,28,,1)");
		checkInOrderWalkPostDelete45.add("(40,25,30,,1)");
		checkInOrderWalkPostDelete45.add("(50,,25,75,1)");
		checkInOrderWalkPostDelete45.add("(53,55,,54,1)");
		checkInOrderWalkPostDelete45.add("(54,53,,,1)");
		checkInOrderWalkPostDelete45.add("(55,60,53,57,1)");
		checkInOrderWalkPostDelete45.add("(56,57,,,1)");
		checkInOrderWalkPostDelete45.add("(57,55,56,58,1)");
		checkInOrderWalkPostDelete45.add("(58,57,,,1)");
		checkInOrderWalkPostDelete45.add("(60,75,55,70,1)");
		checkInOrderWalkPostDelete45.add("(70,60,,,1)");
		checkInOrderWalkPostDelete45.add("(75,50,60,90,1)");
		checkInOrderWalkPostDelete45.add("(80,90,,,1)");
		checkInOrderWalkPostDelete45.add("(90,75,80,95,1)");
		checkInOrderWalkPostDelete45.add("(91,93,,,1)");
		checkInOrderWalkPostDelete45.add("(93,95,91,,1)");
		checkInOrderWalkPostDelete45.add("(95,90,93,,1)");
		checkInOrderWalkPostDelete45Array = checkInOrderWalkPostDelete45.toArray(new String[0]);
		
		// expected result for adding 31 keys and deleting two
		checkInOrderWalkPostDelete45And95 = new java.util.ArrayList<>();
		checkInOrderWalkPostDelete45And95.add("(4,8,,,1)");
		checkInOrderWalkPostDelete45And95.add("(8,10,4,9,1)");
		checkInOrderWalkPostDelete45And95.add("(9,8,,,1)");
		checkInOrderWalkPostDelete45And95.add("(10,15,8,12,1)");
		checkInOrderWalkPostDelete45And95.add("(11,12,,,1)");
		checkInOrderWalkPostDelete45And95.add("(12,10,11,13,1)");
		checkInOrderWalkPostDelete45And95.add("(13,12,,,1)");
		checkInOrderWalkPostDelete45And95.add("(15,25,10,20,1)");
		checkInOrderWalkPostDelete45And95.add("(20,15,,,1)");
		checkInOrderWalkPostDelete45And95.add("(25,50,15,40,1)");
		checkInOrderWalkPostDelete45And95.add("(27,28,,,1)");
		checkInOrderWalkPostDelete45And95.add("(28,30,27,29,1)");
		checkInOrderWalkPostDelete45And95.add("(29,28,,,1)");
		checkInOrderWalkPostDelete45And95.add("(30,40,28,,1)");
		checkInOrderWalkPostDelete45And95.add("(40,25,30,,1)");
		checkInOrderWalkPostDelete45And95.add("(50,,25,75,1)");
		checkInOrderWalkPostDelete45And95.add("(53,55,,54,1)");
		checkInOrderWalkPostDelete45And95.add("(54,53,,,1)");
		checkInOrderWalkPostDelete45And95.add("(55,60,53,57,1)");
		checkInOrderWalkPostDelete45And95.add("(56,57,,,1)");
		checkInOrderWalkPostDelete45And95.add("(57,55,56,58,1)");
		checkInOrderWalkPostDelete45And95.add("(58,57,,,1)");
		checkInOrderWalkPostDelete45And95.add("(60,75,55,70,1)");
		checkInOrderWalkPostDelete45And95.add("(70,60,,,1)");
		checkInOrderWalkPostDelete45And95.add("(75,50,60,90,1)");
		checkInOrderWalkPostDelete45And95.add("(80,90,,,1)");
		checkInOrderWalkPostDelete45And95.add("(90,75,80,93,1)");
		checkInOrderWalkPostDelete45And95.add("(91,93,,,1)");
		checkInOrderWalkPostDelete45And95.add("(93,90,91,,1)");
		checkInOrderWalkPostDelete45And95Array = checkInOrderWalkPostDelete45And95.toArray(new String[0]);
		
		// expected result for adding 31 keys and deleting three
		checkInOrderWalkPostDelete45And95And60 = new java.util.ArrayList<>();
		checkInOrderWalkPostDelete45And95And60.add("(4,8,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(8,10,4,9,1)");
		checkInOrderWalkPostDelete45And95And60.add("(9,8,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(10,15,8,12,1)");
		checkInOrderWalkPostDelete45And95And60.add("(11,12,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(12,10,11,13,1)");
		checkInOrderWalkPostDelete45And95And60.add("(13,12,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(15,25,10,20,1)");
		checkInOrderWalkPostDelete45And95And60.add("(20,15,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(25,50,15,40,1)");
		checkInOrderWalkPostDelete45And95And60.add("(27,28,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(28,30,27,29,1)");
		checkInOrderWalkPostDelete45And95And60.add("(29,28,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(30,40,28,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(40,25,30,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(50,,25,75,1)");
		checkInOrderWalkPostDelete45And95And60.add("(53,55,,54,1)");
		checkInOrderWalkPostDelete45And95And60.add("(54,53,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(55,70,53,57,1)");
		checkInOrderWalkPostDelete45And95And60.add("(56,57,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(57,55,56,58,1)");
		checkInOrderWalkPostDelete45And95And60.add("(58,57,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(70,75,55,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(75,50,70,90,1)");
		checkInOrderWalkPostDelete45And95And60.add("(80,90,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(90,75,80,93,1)");
		checkInOrderWalkPostDelete45And95And60.add("(91,93,,,1)");
		checkInOrderWalkPostDelete45And95And60.add("(93,90,91,,1)");
		checkInOrderWalkPostDelete45And95And60Array = checkInOrderWalkPostDelete45And95And60.toArray(new String[0]);
		
		// expected result for adding 31 keys and deleting four
		checkInOrderWalkPostDelete45And95And60And50 = new java.util.ArrayList<>();
		checkInOrderWalkPostDelete45And95And60And50.add("(4,8,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(8,10,4,9,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(9,8,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(10,15,8,12,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(11,12,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(12,10,11,13,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(13,12,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(15,25,10,20,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(20,15,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(25,53,15,40,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(27,28,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(28,30,27,29,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(29,28,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(30,40,28,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(40,25,30,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(53,,25,75,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(54,55,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(55,70,54,57,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(56,57,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(57,55,56,58,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(58,57,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(70,75,55,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(75,53,70,90,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(80,90,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(90,75,80,93,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(91,93,,,1)");
		checkInOrderWalkPostDelete45And95And60And50.add("(93,90,91,,1)");
		checkInOrderWalkPostDelete45And95And60And50Array = checkInOrderWalkPostDelete45And95And60And50.toArray(new String[0]);
	}

	@BeforeEach
	void setUp() throws Exception 
	{
		// tree to use for a few of the smaller insert key tests
		tree = new BinarySearchTree();
		
		// tree to use for the tests related to the 31 key tree
		t = new BinarySearchTree();
		
		// the list of 31 keys, will be used in multiple tests
		int[] keys = new int[] {50, 25, 75, 15, 40, 60, 90, 10, 20, 30, 45, 55, 
				70, 80, 95, 8, 12, 28, 4, 9, 11, 13, 27, 29, 53, 57, 54, 56, 58, 93, 91};
		
		// add the 31 keys to the tree
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			t.insertNode(n);
		}
	}

	@Test
	void testInsertRoot() 
	{
		// define one key to add to the tree
		int[] keys = new int[] {20};
		
		// add the key(s)
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		tree.inOrderWalk(tree.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
		
		assertArrayEquals(checkInOrderWalkInsertRootArray, inOrderWalkArray);
	}
	
	@Test
	void testInsertTwoNodes() 
	{
		// define two keys to add to the tree
		int[] keys = new int[] {20, 10};
		
		// add the key(s)
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		tree.inOrderWalk(tree.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);

		assertArrayEquals(checkInOrderWalkInsertTwoNodesArray, inOrderWalkArray);
	}
		
	@Test
	void testInsertThreeNodes() 
	{
		// define three keys to add to the tree
		int[] keys = new int[] {20, 10, 30};
		
		// add the key(s)
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		tree.inOrderWalk(tree.getRoot(), inOrderWalk);
		
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
				
		assertArrayEquals(checkInOrderWalkInsertThreeNodesArray, inOrderWalkArray);
	}
	
	@Test
	void testInsertSevenNodes() 
	{
		// define seven keys to add to the tree
		int[] keys = new int[] {20, 10, 30, 5, 15, 25, 35};
		
		// add the key(s)
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		tree.inOrderWalk(tree.getRoot(), inOrderWalk);
		
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
				
		assertArrayEquals(checkInOrderWalkInsertSevenNodesArray, inOrderWalkArray);
	}
	
	@Test
	void testGetSuccessorOfRootForSevenNodesTree() 
	{
		int[] keys = new int[] {20, 10, 30, 5, 15, 25, 35};
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		assertEquals("(25,30,,,1)", tree.getSuccessor(tree.getRoot()).toString());
	}
	
	@Test
	void testInsertThirtyOneNodes() 
	{	
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		t.inOrderWalk(t.getRoot(), inOrderWalk);
		
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
				
		assertArrayEquals(checkInOrderWalkInsertThirtyOneNodesArray, inOrderWalkArray);
	}
	
	@Test
	void testGetHeightForSubtreeRootedAt60() 
	{
		// check the height of a subtree of the 31 key tree
		assertEquals(3, t.getHeight(t.getNode(t.getRoot(), 60)));
	}
	
	@Test
	void testGetMax() 
	{	
		// check the max of the 31 key tree
		assertEquals("(95,90,93,,1)", t.getMax(t.getRoot()).toString());
	}
		
	@Test
	void testGetMin() 
	{	
		// check the min of the 31 key tree
		assertEquals("(4,8,,,1)", t.getMin(t.getRoot()).toString());
	}
	
	@Test
	void testGetNodeNotFound() 
	{	
		// check getNode() for key 99 of the 31 key tree, should return
		// null since there is no node with a key of 99
		assertNull(t.getNode(t.getRoot(), 99));
	}
	
	@Test
	void testPredecessorWithNoLeftChild() 
	{	
		// check predecessor for node with key 91 of the 31 key tree
		// the node with key 91 has no left child
		assertEquals("(90,75,80,95,1)", t.getPredecessor(t.getNode(t.getRoot(), 91)).toString());
	}
	
	@Test
	void testPredecessorWithLefthild() 
	{	
		// check predecessor for node with key 10 of the 31 key tree
		// the node with key 10 has a left child
		assertEquals("(9,8,,,1)", t.getPredecessor(t.getNode(t.getRoot(), 10)).toString());
	}
	
	@Test
	void testPredecessorOnMin() 
	{
		// check predecessor for node with key 4 of the 31 key tree
		// the node with key 4 is the min key in the tree, so it should return null
		assertNull(t.getPredecessor(t.getNode(t.getRoot(), 4)));
	}
	
	@Test
	void testSuccessorWithNoRightChild() 
	{	
		// check the successor of the node with key 45 of the 31 key tree
		// the node with key 45 has no right child
		assertEquals("(50,,25,75,1)", t.getSuccessor(t.getNode(t.getRoot(), 45)).toString());
	}
	
	@Test
	void testSuccessorWithRightChild() 
	{
		// check the successor of the node with key 50 of the 31 key tree
		// the node with key 45 has a right child
		assertEquals("(53,55,,54,1)", t.getSuccessor(t.getNode(t.getRoot(), 50)).toString());
	}
	
	@Test
	void testSuccessorOnMax() 
	{	
		// check the successor of the node with key 95 of the 31 key tree
		// the node with key 95 is the max key of the tree, so it has no successor
		assertNull(t.getSuccessor(t.getNode(t.getRoot(), 95)));
	}
	
	@Test
	void testDeleteNode45() 
	{
		// delete the node with key 45 from the 31 key tree
		int[] keysToDelete = new int[] {45};
		for( int i = 0; i < keysToDelete.length; i++ )
		{
			Node node = t.getNode(t.getRoot(), keysToDelete[i]);
			t.deleteNode(node);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		t.inOrderWalk(t.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);

		assertArrayEquals(checkInOrderWalkPostDelete45Array, inOrderWalkArray);
	}
	
	@Test
	void testDeleteNode45And95And60() 
	{
		// delete the nodes with keys 45, 95, and 60 from the 31 key tree
		int[] keysToDelete = new int[] {45, 95, 60};
		for( int i = 0; i < keysToDelete.length; i++ )
		{
			Node node = t.getNode(t.getRoot(), keysToDelete[i]);
			t.deleteNode(node);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		t.inOrderWalk(t.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
				
		assertArrayEquals(checkInOrderWalkPostDelete45And95And60Array, inOrderWalkArray);
	}
	
	@Test
	void testDeleteNode45And95And60And50() 
	{
		// delete the nodes with keys 45, 95, 60, and 95 from the 31 key tree
		int[] keysToDelete = new int[] {45, 95, 60, 50};
		for( int i = 0; i < keysToDelete.length; i++ )
		{
			Node node = t.getNode(t.getRoot(), keysToDelete[i]);
			t.deleteNode(node);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		t.inOrderWalk(t.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);
				
		assertArrayEquals(checkInOrderWalkPostDelete45And95And60And50Array, inOrderWalkArray);
	}
	
	// unimplemented tests start here
	
	@Test
	void testInsertTwoNodesB() 
	{
		// define two keys to add to the tree
		int[] keys = new int[] {20, 30};
		
		// add the key(s)
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		tree.inOrderWalk(tree.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);

		assertArrayEquals(checkInOrderWalkInsertTwoNodesBArray, inOrderWalkArray);
	}
	
	@Test
	void testGetHeightForSevenNodesTree() 
	{
		int[] keys = new int[] {20, 10, 30, 5, 15, 25, 35};
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		assertEquals(2, tree.getHeight(tree.getRoot()));	
	}
	
	@Test
	void testGetPredecessorOfRootForSevenNodesTree() 
	{
		int[] keys = new int[] {20, 10, 30, 5, 15, 25, 35};
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		assertEquals("(15,10,,,1)", tree.getPredeccessor(tree.getRoot()).toString());
	}
	
	@Test
	void testGetHeight() 
	{	
		assertEquals(5, t.getHeight(t.getRoot()));
	}
	
	@Test
	void testGetRoot() 
	{
		assertEquals("(50,,25,75,1)", t.getRoot(t.getRoot()).toString());
	}
	
	@Test
	void testGetNode() 
	{	
		assertEquals("(91,93,,,1)", t.getNode(t.getRoot(),91).toString());
	}
	
	@Test
	void testDeleteNode45And95() 
	{
		int[] keysToDelete = new int[] {45, 95};
		for( int i = 0; i < keysToDelete.length; i++ )
		{
			Node node = t.getNode(t.getRoot(), keysToDelete[i]);
			t.deleteNode(node);
		}
		
		// get an in order walk to verify the nodes are in the proper locations
		java.util.ArrayList<String> inOrderWalk = new java.util.ArrayList<>();
		t.inOrderWalk(t.getRoot(), inOrderWalk);
		
		// get an array of the in order walk to compare with the expected result
		String[] inOrderWalkArray = inOrderWalk.toArray(new String[0]);

		assertArrayEquals(checkInOrderWalkPostDelete45And95Array, inOrderWalkArray);
	}
	
	@Test
	void testCountForDuplicateNode() 
	{
		int[] keys = new int[] {20, 10, 30, 35, 5, 35, 15, 35, 25, 35};
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		assertEquals(4, tree.getNode(tree.getRoot(), 35).getCount());
	}
	
	@Test
	void testCountForDuplicateNodeWithDelete() 
	{
		int[] keys = new int[] {20, 10, 30, 35, 5, 35, 15, 35, 25, 35};
		for( int i = 0; i < keys.length; i++ )
		{
			Node n = new Node(keys[i]);
			tree.insertNode(n);
		}
		Node node = tree.getNode(tree.getRoot(), 35);
		tree.deleteNode(node);
		node = tree.getNode(tree.getRoot(), 35);
		tree.deleteNode(node);
		assertEquals(2, tree.getNode(tree.getRoot(), 35).getCount()
);
	}

}
