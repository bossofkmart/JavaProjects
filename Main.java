package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(0);

    // Adding nodes
    bst.insert(5);
    bst.insert(3);
    bst.insert(7);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(8);
    bst.insert(1);
    bst.insert(9);

    System.out.println("Before removing range:");
    System.out.println("Pre-order traversal:");
    bst.printPreOrderTraversal();
    System.out.println();
    System.out.println("Post-order traversal:");
    bst.printPostOrderTraversal();
    System.out.println();

    // Removing nodes within the range [3, 7]
    bst = bst.remove_range(3, 7);

    System.out.println("After removing range [3, 7]:");
    System.out.println("Pre-order traversal:");
    bst.printPreOrderTraversal();
    System.out.println();
    System.out.println("Post-order traversal:");
    bst.printPostOrderTraversal();
  }

  }
