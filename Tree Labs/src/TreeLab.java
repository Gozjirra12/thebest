
/**
* Name: Justin Krisanda                  
* Period: 5
* 
* Purpose of the Program: To further understand tree methods and their purposes through implementation.
* Date Submitted: 1/21/19
* 
* What I learned: I gained a much better understanding of how trees work and their purpose.
* 
* How I feel about this lab: At first I was puzzled by this lab. As I worked through the lab I found it to be much simpler than I had first pictured.
* 							
* 	
* What I wonder: I wonder what the purpose of displaying a tree sideways is.
* Credits: Comp Sci tutor
* Students whom I helped (to what extent): 
*/

import java.util.*; //for the queue interface

public class TreeLab {
	public static void main(String[] args) {
		String s = "XCOMPUTERSCIENCE";

		TreeNode root = new TreeNode("" + s.charAt(1), null, null);

		// The root node has index 1
		// The second level nodes' indices: 2, 3
		// The third level nodes' indices: 4,5,6,7
		// Idea: based on the index of the node, log (pos) of base 2 calculates the
		// level of the
		// node: root (index 1) on level 1. Node with index 2 or 3 is on level 2
		for (int pos = 2; pos < s.length(); pos++)
			insert(root, "" + s.charAt(pos), pos, (int) (1 + Math.log(pos) / Math.log(2)));

		// NOTE: The following 3 lines are supposed to further show you how insert
		// works. You
		// uncomment them and see how the tree looks like with these 3 additional nodes
		 insert(root, "A", 17, 5);
		 insert(root, "B", 18, 5);
		 insert(root, "C", 37, 6); //B's right child

		// display the tree sideway; see the sample output at the end of this file
		display(root, 0);

		System.out.print("\nPreorder: ");
		preorderTraverse(root);
		System.out.print("\nInorder: ");
		inorderTraverse(root);
		System.out.print("\nPostorder: ");
		postorderTraverse(root);

		System.out.println("\n\nNodes = " + countNodes(root));
		System.out.println("Leaves = " + countLeaves(root));
		System.out.println("Grandparents = " + countGrandParentNodes(root)); // count the number grandparent nodes
		System.out.println("Only childs = " + countSingleChildNodes(root)); // count the number of nodes that has only 1
																			// child

		System.out.println("\nDepth = " + depth(root));
		System.out.println("Height = " + height(root));

		System.out.println("Min = " + min(root));
		System.out.println("Max = " + max(root));

		System.out.println("\nBy Level: ");
		displayLevelOrder(root); // level by level display of the nodes (starts from left to right for nodes on
									// the same level)

	} // end of main

	// insert a new node in the tree based on the node's level
	public static void insert(TreeNode t, String s, int pos, int level) {
		TreeNode p = t;
		for (int k = level - 2; k > 0; k--)
			// then 1 << 4 will insert four 0-bits at the right of 1 (binary representation
			// of 1 is 1.
			// 1 << 4 results in 10000 (in binary)
			if ((pos & (1 << k)) == 0)
			{
				p = p.getLeft(); // What does this do? Answer this question first. What does '&' do? Google
				System.out.println((pos)+" " + (1<<k));
			}
									// it!!!!
			else // We did not learn this in AP CS A! :
				p = p.getRight(); // What does this do? Answer this question first.

		if ((pos & 1) == 0)
			p.setLeft(new TreeNode(s, null, null));
		else
			p.setRight(new TreeNode(s, null, null));
	} // end of insert

	/*****************************************************************************************************
	 * postcondition: display the tree sideway
	 *****************************************************************************************************/
	public static void display(TreeNode t, int level) {
		if (t == null)
			return;
		display(t.getRight(), level + 1); // recurse right

		for (int k = 0; k < level; k++)
			System.out.print("\t");
		System.out.println(t.getValue());

		display(t.getLeft(), level + 1); // recurse left
	} // end of display

	public static void preorderTraverse(TreeNode t) {
		System.out.print(t.getValue() + " ");
		if (t.getLeft() != null)
			preorderTraverse(t.getLeft());
		if (t.getRight() != null)
			preorderTraverse(t.getRight());
	}

	public static void inorderTraverse(TreeNode t) {
		if (t.getLeft() != null)
			inorderTraverse(t.getLeft());
		System.out.print(t.getValue() + " ");
		if (t.getRight() != null)
			inorderTraverse(t.getRight());
	}

	public static void postorderTraverse(TreeNode t) {
		if (t.getLeft() != null)
			postorderTraverse(t.getLeft());
		if (t.getRight() != null)
			postorderTraverse(t.getRight());
		System.out.print(t.getValue() + " ");
	}

	public static int countNodes(TreeNode t) {
		if (t == null) // base case
			return 0;
		int count = 1; // counts the first node
		if (t.getLeft() != null) // traverses the tree, incrementing count by 1 for each call
			count += countNodes(t.getLeft());
		if (t.getRight() != null)
			count += countNodes(t.getRight());
		return count;
	}

	public static int countLeaves(TreeNode t) {

		if (t == null) // base case
			return 0;
		if (t.getLeft() == null && t.getRight() == null) // checks that the node has no children
			return 1;
		else
			return countLeaves(t.getLeft()) + countLeaves(t.getRight()); // recursive call to go through the whle tree
	}

	public static int countGrandParentNodes(TreeNode t) {
		if (t == null) // base case
			return 0;
		if (t.getLeft() != null && t.getRight() != null) // checks if the current node is full
			if (t.getLeft().getLeft() != null || t.getLeft().getRight() != null || t.getRight().getRight() != null
					|| t.getRight().getLeft() != null) // checks if the current node's children has children
				return countGrandParentNodes(t.getLeft()) + countGrandParentNodes(t.getRight()); // recursive call
		return 1;
	}

	public static int countSingleChildNodes(TreeNode t) {
		if (t == null) // base case
			return 0;
		int count = 0;
		if ((t.getLeft() == null && t.getRight() != null) || (t.getLeft() != null && t.getRight() == null)) // checks
																											// that the
																											// current
																											// node only
																											// has 1
																											// child
			count++;
		count += (countSingleChildNodes(t.getLeft()) + countSingleChildNodes(t.getRight())); // adds the amount of
																								// children from
																								// previous calls
		return count;
	}

	public static int depth(TreeNode t) {
		int temp1 = 0;
		int temp2 = 0;
		if (t == null)
			return -1;
		else {
			if (t.getLeft() != null)
				temp1 = depth(t.getLeft());
			if (t.getRight() != null)
				temp2 = depth(t.getRight());
			return Math.max(temp1, temp2) + 1;
		}
	}

	public static int height(TreeNode t) {
		if (t == null)
			return -1;
		int left = height(t.getLeft());
		int right = height(t.getRight());
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public static Object min(TreeNode t) {
		String current = t.getValue().toString();
		String left;
		String right;
		// set current to min value between present node and left node
		if (t.getLeft() != null) {
			left = (String) min(t.getLeft());
			if (!(current.compareTo(left) < 0))
				current = left;
		}
		// compare outcome of previous to the right child
		if (t.getRight() != null) {
			right = (String) min(t.getRight());
			if (!(current.compareTo(right) < 0))
				current = right;
		}
		return current;
	}

	public static Object max(TreeNode t) {
		String current = t.getValue().toString();
		String left;
		String right;
		// set current to max value between present node and left node
		if (t.getLeft() != null) {
			left = (String) max(t.getLeft());
			if (!(current.compareTo(left) > 0))
				current = left;
		}
		// compare outcome of previous to the right child
		if (t.getRight() != null) {
			right = (String) max(t.getRight());
			if (!(current.compareTo(right) > 0))
				current = right;
		}
		return current;
	}

	/*****************************************************************************************************
	 * This method is not recursive. Hint: Use a local queue to store the children
	 * of the current node.
	 *****************************************************************************************************/
	public static void displayLevelOrder(TreeNode t) {
		if (t == null)
			return;
		Queue<TreeNode> q = new LinkedList<TreeNode>(); //
		q.add(t);
		while (true) {
			int numOfNodes = q.size();
			if (numOfNodes == 0)
				break;
			while (numOfNodes > 0) {
				TreeNode temp = q.peek();
				System.out.print(temp.getValue());
				q.remove();
				if (temp.getLeft() != null)
					q.add(temp.getLeft());
				if (temp.getRight() != null)
					q.add(temp.getRight());
				numOfNodes--;
			}
		}
	}
} // end of TreeLab_shell

/***************************************************

----jGRASP exec: java Lab01

			E
		E
			C
	M
			N
		T
			E
C
			I
		U
			C
	O
			S
					C
				B
		P
				A
			R

Preorder: C O P R A S B C U C I M T E N E C E 
Inorder: R A P B C S O C U I C E T N M C E E 
Postorder: A R C B S P C I U O E N T C E E M C 

Nodes = 18
Leaves = 8
Grandparents = 5
Only childs = 3

Depth =45
Height = 4
Min = A
Max = U

By Level: 
COMPUTERSCIENCEABC

*******************************************************/
/* TreeNode class for the AP Exams */

class TreeNode {
	private Object value;
	private TreeNode left, right;

	public TreeNode(Object initValue) {
		value = initValue;
		left = null;
		right = null;
	}

	public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight) {
		value = initValue;
		left = initLeft;
		right = initRight;
	}

	public Object getValue() {
		return value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setValue(Object theNewValue) {
		value = theNewValue;
	}

	public void setLeft(TreeNode theNewLeft) {
		left = theNewLeft;
	}

	public void setRight(TreeNode theNewRight) {
		right = theNewRight;
	}
}