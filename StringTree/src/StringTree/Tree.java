package StringTree;

import java.util.Scanner;

public class Tree {
	
	Node root;
	public Tree()
	{
		root=null;
	}
	public Tree(Node root)
	{
		this.root=root;
	}
	
	public void visit(Node p)
	{
		System.out.println(p.value + " ");
	}

	public void inOrder(Node root)
	{
		if(root==null) return;
		inOrder(root.left);
		visit(root);
		inOrder(root.right);
	}


	public void insertWord(String newWord) {
        // Add the word to the binary sort tree to which the
        // global variable "root" refers.  Duplicate entries
        // will be ignored!  All words are converted to lower case.
			
  newWord = newWord.toLowerCase();
  if ( root == null ) {
          // The tree is empty.  Set root to point to a new node 
          // containing the new item.
      root = new Node( newWord );
      return;
   }
  Node runner; // Runs down the tree to find a place for newItem.
   runner = root;   // Start at the root.
   while (true) {
      if ( newWord.equals(runner.value) ) {
              // The word is already in the tree.  Don't insert
              // another copy.  Just return.
          return;
      }
      if ( newWord.compareTo(runner.value) < 0 ) {
               // Since the new item is less than the item in runner,
               // it belongs in the left subtree of runner.  If there
               // is an open space at runner.left, add a node there.
               // Otherwise, advance runner down one level to the left.
         if ( runner.left == null ) {
            runner.left = new Node( newWord );
            return;  // New item has been added to the tree.
         }
         else
            runner = runner.left;
      }
      else {
               // Since the new item is greater than or equal to the 
               // item in runner, it belongs in the right subtree of
               // runner.  If there is an open space at runner.right, 
               // add a new node there.  Otherwise, advance runner
               // down one level to the right.
         if ( runner.right == null ) {
            runner.right = new Node( newWord );
            return;  // New item has been added to the tree.
         }
         else
            runner = runner.right;
       }
   } // end while
}  // end insertWord()
}
