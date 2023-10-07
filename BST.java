//BST class

/**
 * The BST class implements a binary search tree. A binary search tree (BST) 
 * is a useful form of a binary tree. A BST has an ordering property where any
 * node's left subtree keys ≤ the node's key, and the right subtree's keys ≥ the
 * node's key, enables faster searching for an item.
 * 
 * @param <T> generic format, yet specifically a string in this lab.
 */

public class BST<T extends Comparable<T>> {

	private BSTNode<T> root;

	// constructor
	public BST() {
		root = null;
	}

	// constructor
	public BST(T title) {
		root = new BSTNode<T>(title);
	}

	/**
	 * A BST defines an ordering among nodes. The Node class has a
	 * generic key value and data members for the left and right child nodes. 
	 *
	 * @param <T> generic, yet specifically a string in this lab.
	 */
	private class BSTNode<T extends Comparable<T>> {
		private T data;
		private BSTNode<T> left, right;

		// Constructor.
		public BSTNode() {
			data = null;
		}

		// Constructor.
		public BSTNode(T node) {
			data = node;
			left = null;
			right = null;
		}
	}

	/**
	 * Removes the first found matching node, restructuring the
	 * tree to preserve the BST ordering property. The algorithm first searches for
	 * a matching node and performs one of the following sub-algorithms: removing
	 * a leaf node, removing an internal node with single child, or removing
	 * an internal node with two children.
	 * 
	 * @param key desired node to remove
	 * @return node not found
	 */
	
	// delete
	protected boolean delete(T item) {
		BSTNode<T> parent = null;
		BSTNode<T> pointer = root;

		while (pointer != null) {
			// Check if currentNode has a matching key
			if (pointer.data == item) {
				if (pointer.left == null && pointer.right == null) { // a leaf node
					if (parent == null) { // Node is root
						root = null;
					} else if (parent.left == pointer) {
						parent.left = null;
					} else {
						parent.right = null;
					}
					return true; // Node found and removed
					
				} else if (pointer.left != null && pointer.right == null) { // one child- left
					if (parent == null) { // Node is root
						root = pointer.left;
					} else if (parent.left == pointer) {
						parent.left = pointer.left;
					} else {
						parent.right = pointer.left;
					}
					return true; // Node found and removed
					
				} else if (pointer.left == null && pointer.right != null) { // one child- right
					if (parent == null) { // Node is root
						root = pointer.right;
					} else if (parent.left == pointer) {
						parent.left = pointer.right;
					} else {
						parent.right = pointer.right;
					}
					return true; // Node found and removed
					
				} else { // two children
					
					// Find successor (leftmost child of right subtree)
					BSTNode<T> successor = pointer.right;
					while (successor.left != null) {
						successor = successor.left;
					}
					pointer.data = (T) successor.data; 
					parent = pointer;
					pointer = pointer.right; // Remove successor from right subtree
					item = (T) successor.data; // Loop continues with new key
				}
			} else if (pointer.data.compareTo(item) < 0) {//search right
				parent = pointer;
				pointer = pointer.right;
			} else { // Search left
				parent = pointer;
				pointer = pointer.left;
			}
		}
		return false;
	}

	
	/**
	 * Inserts the new node in a proper location according to the BST ordering
	 * property and will insert the new node accordingly to either the root, as a left
	 * child, or as a right child.
	 * 
	 * @param data node to add.
	 * @return the new node.
	 */
//insert
	protected BSTNode<T> insert(T data) {

		BSTNode<T> temp = new BSTNode<T>(data);
		if (root == null) {
			root = temp;
			return temp; // inserted
		}
		return insert(data, root);
	}

	protected BSTNode<T> insert(T data, BSTNode<T> pointer) {

		BSTNode<T> temp = new BSTNode<T>(data);
		
		if (pointer == null) {
			pointer = temp;
			return temp; // inserted
		}
		else if (data.compareTo(pointer.data) > 0) {
			if (pointer.right == null) {
				pointer.right = temp;
				return pointer.right;
			} else {
				return insert(data, pointer.right);
			}
		} else if (data.compareTo(pointer.data) < 0) {
			if (pointer.left == null) {
				pointer.left = temp;
				return pointer.left;
			} else {
				return insert(data, pointer.left);
			}
		} else {// (data.compareTo(pointer.data) == 0) {
			return pointer;
		}
	}
	

	/**
	 * Searches the tree by visiting the root node then continues to perform
	 * comparisons.
	 * 
	 * @param item desired key to find.
	 * @return first node found matching the key or returns null if a
	 *         node is not found.
	 */
	
	// search
	protected BSTNode<T> search(T item) {
		return search(item, root);
	}

	protected BSTNode<T> search(T item, BSTNode<T> root) {
		if (root == null) {
			return null;
		}
		if (root.data.compareTo(item) == 0) {
			return root;
		} else if (root.data.compareTo(item) > 0) {
			return search(item, root.left);
		} else if (root.data.compareTo(item) < 0) {
			return search(item, root.right);
		} else {
			return null;
		}
	}

// inorder traversal 
	/**
	 * Prints the tree in a specific order: traverses the left subtree, visits the
	 * root, then traverses the right subtree.
	 */
	// has no root
	private void inOrder() {
		inOrder(root);
	}

	// has a root
	private void inOrder(BSTNode<T> node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(" [" + node.data + "] ");
		inOrder(node.right);
	}

	public static void main(String[] args) {
		BST<String> bookTitles;
		bookTitles = new BST<String>();

		// insertion
		bookTitles.insert("The Great Gatsby");
		bookTitles.insert("Great Expectations");
		bookTitles.insert("The Grapes of Wrath");
		bookTitles.insert("Les Miserables");
		bookTitles.insert("Moby Dick");
		bookTitles.insert("The Odyssey");
		bookTitles.insert("Alice's Adventures in Wonderland");
		bookTitles.insert("Charlotte's Web");
		bookTitles.insert("Harry Potter");
		bookTitles.insert("Hamlet");
		System.out.println();
		System.out.println();

		System.out.println("----Insertion Complete. Printing tree nodes in inOrder----");
		bookTitles.inOrder();
		System.out.println();
		System.out.println();

		System.out.println("----Deleting node Harry Potter----");
		bookTitles.delete("Harry Potter");
		bookTitles.inOrder();
		System.out.println();
		System.out.println();

		System.out.println("----Searching ----");

		System.out.println("----Testing for a listed node-Les Miserables----");
		if (bookTitles.search("Les Miserables") != null) {
			System.out.println("Found key! ");
		} else {
			System.out.println("Key not found.");
		}

		System.out.println();

		System.out.println("----Testing for a node not listed- Great Travels----");
		if (bookTitles.search("Great ") != null) {
			System.out.println("Found key! ");
		} else {
			System.out.println("Key not found.");
		}
		System.out.println();
	}
}
