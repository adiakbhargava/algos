package treeimpls.RBTreez;

import java.util.ArrayList;

public class RBTree<T extends Comparable<T>> {
  private Node<T> root;

  /**
   * creates an instance of RBTree(), initially sets root to null
   */
  public RBTree() {
    this.root = null;
  }

  /**
   * returns root of tree
   * 
   * @return root
   */
  private Node<T> getRoot() {
    return root;
  }

  /**
   * traverses through tree to find node with value o
   * 
   * @param T o
   * @return node with value o
   */
  public Node<T> search(T o) {
    return searchHelper(getRoot(), o);
  }

  /**
   * helper method for search(), checks current value of node to 'o' in order to see where the
   * desired node in the tree is
   * 
   * @param T       o
   * @param Node<T> node
   * @return node with value o
   */
  private Node<T> searchHelper(Node<T> node, T o) {
    // compares value of o to current node
    int cmp = o.compareTo(node.getValue());
    // return node if values match
    if (cmp == 0) {
      return node;
    }

    // edge case -> traversed to right leaf node
    if (cmp == 1 && node.getRight() == null) {
      return null;
    }

    // edge case -> traversed to left leaf node
    if (cmp == -1 && root.getLeft() == null) {
      return null;
    }

    // recursive case -> traverse to right subtree if value of o was greater than current node,
    // traverse to left subtree otherwise
    if (cmp == 1) {
      return searchHelper(node.getRight(), o);
    } else {
      return searchHelper(node.getLeft(), o);
    }
  }

  /**
   * Helper method that changes color of parent, sibling, and grandparent nodes based off the given
   * value of 'c'
   * 
   * @param node
   * @param sibling
   * @param c
   */
  private void recolor(Node<T> node, Node<T> sibling) {
    // recolors parent, sibling, and potentially grandparent node
    node.setColor('r');
    sibling.setColor('r');
    if (node.getParent() != root) {
      node.getParent().setColor('r');
    }
  }

  /**
   * inserts node with specific value 'o' and re-balances tree based off the insertion
   * 
   * @param T o
   */
  public void insert(T o) {
    // sets root to root node of tree after insertion
    root = insertHelper(getRoot(), o, null);
  }

  /**
   * helper method for insert(), implements rules for insertion of node in tree along with rotation
   * and re-coloring cases
   * 
   * @param node
   * @param o
   * @param parent
   * @return root node of potentially rotated and recolored tree
   */
  private Node<T> insertHelper(Node<T> node, T o, Node<T> parent) {
    // base case -> create and return node with value 'o' if current node is null
    if (node == null) {
      node = new Node<T>(o);
      node.setParent(parent);

      if (getRoot() == null) {
        node.setColor('b');
      }
      return node;
    }

    // compares value of 'o' to current node
    int cmp = o.compareTo(node.getValue());
    // recurse left if 'o' is less than current node, recurse right otherwise
    if (cmp == -1) {
      // checks if returned node from recursive call contains a rotated tree or not
      // if possiblyRotatedNode's parent is same as current node, then current node's left child
      // is set to possiblyRotatedNode. Otherwise, possiblyRotatedNode is returned
      Node<T> possiblyRotatedNode = insertHelper(node.getLeft(), o, node);
      if (possiblyRotatedNode.getParent() != null
          && possiblyRotatedNode.getParent().getValue().compareTo(node.getValue()) == 0) {
        node.setLeft(possiblyRotatedNode);
      } else {
        return possiblyRotatedNode;
      }
    } else if (cmp == 1) {
      // checks if returned node from recursive call contains a rotated tree or not
      // if possiblyRotatedNode's parent is same as current node, then current node's right child
      // is set to possiblyRotatedNode. Otherwise, possiblyRotatedNode is returned
      Node<T> possiblyRotatedNode = insertHelper(node.getRight(), o, node);
      if (possiblyRotatedNode.getParent() != null
          && possiblyRotatedNode.getParent().getValue().compareTo(node.getValue()) == 0) {
        node.setRight(possiblyRotatedNode);
      } else {
        return possiblyRotatedNode;
      }
    } else if (cmp == 0) {
      // prevents duplicates, returns current node if node has same value as 'o'
      return node;
    }

    // creates and sets value of parent node's sibling node
    Node<T> sibling = null;
    // only checks right and left child of grandparent node if grandparent node exists
    if (node.getParent() != null) {
      // sibling is set to whichever child is not the current parent node
      if (node.getParent().getRight() == node) {
        sibling = node.getParent().getLeft();
      } else {
        sibling = node.getParent().getRight();
      }
    }

    // checks parent node's color, does nothing if parent node is black, otherwise,
    // runs rotation and re-color code
    if (node.getColor() == 'r') {
      // case 2a -- sibling is null or black
      if (sibling == null || sibling.getColor() == 'b') {
        // checks for which rotation should be performed based off cmp of inserted node.
        // cases for which sibling is right child of grandparent node
        if (node.getParent().getRight() == sibling) {
          // rotate right --
          if (cmp == -1) {
            node = rotateRight(node.getParent());
          } else {
            // rotate left , then right --
            Node<T> rotatedNode = rotateLeft(node.getParent().getLeft());
            node = rotatedNode;
            node.getParent().setLeft(rotatedNode);
            node = rotateRight(node.getParent());
          }
        } else if (node.getParent().getLeft() == sibling) {
          // cases for which sibling is left child of grandparent node

          // rotate left --
          if (cmp == 1) {
            node = rotateLeft(node.getParent());
          } else {
            // rotate right, then left --
            Node<T> rotatedNode = rotateRight(node.getParent().getRight());
            node = rotatedNode;
            node.getParent().setRight(rotatedNode);
            node = rotateLeft(node.getParent());
          }
        }
      } else if (sibling.getColor() == 'r') {
        // case 2b -- sibling is red, recolor nodes
        recolor(node, sibling);
      }
    }

    return node;
  }

  /**
   * Helper method that rotates nodes left based off case scenario
   * 
   * @param grandparent node
   * @return new root node of this subtree
   */
  private Node<T> rotateLeft(Node<T> node) {
    // creates temp node set to grandparents node's child
    Node<T> temp = node.getRight();
    // sets grandparent node's right child to temp's left child
    node.setRight(temp.getLeft());
    // sets temp's left child to grandparent node
    temp.setLeft(node);
    // updates new parents for the swapped nodes
    temp.setParent(node.getParent());
    node.setParent(temp);

    // recolors previous grandparent node to red
    temp.getLeft().setColor('r');
    // recolors new grandparent node to black
    temp.setColor('b');

    return temp;
  }

  /**
   * Helper method that rotates nodes right based off case scenario
   * 
   * @param grandparent node
   * @return new root node of this subtree
   */
  public Node<T> rotateRight(Node<T> node) {
    // creates temp node set to grandparent node's child
    Node<T> temp = node.getLeft();
    // sets grandparent node's left child to temp's right child
    node.setLeft(temp.getRight());
    // sets temp's right child to grandparent node
    temp.setRight(node);
    // updates new parents for swapped nodes
    temp.setParent(node.getParent());
    node.setParent(temp);

    // sets previous grandparent node's color to red
    temp.getRight().setColor('r');
    // sets new grandparent node to black
    temp.setColor('b');

    return temp;
  }

  /**
   * prints tree
   * 
   * @param node
   */
  private void printTree(Node<T> node) {
    TreePrinter<Node<T>> printer =
        new TreePrinter<>(n -> "" + n.getValue() + ", c-" + String.valueOf(n.getColor()),
            n -> n.getLeft(), n -> n.getRight());
    printer.setHspace(1);
    printer.setSquareBranches(false);
    printer.setLrAgnostic(true);
    printer.printTree(node);
    System.out.println();
  }

  public void printPreorderTraversal(Node<T> node) {
    if (node == null) {
      return;
    }

    System.out.println(node.toString());

    printPreorderTraversal(node.getLeft());
    printPreorderTraversal(node.getRight());
  }

  public void printInorderTraversal(Node<T> node) {
    if (node == null) {
      return;
    }

    printPreorderTraversal(node.getLeft());
    System.out.println(node.toString());
    printPreorderTraversal(node.getRight());
  }

  public void printPostorderTraversal(Node<T> node) {
    if (node == null) {
      return;
    }

    printPreorderTraversal(node.getLeft());
    printPreorderTraversal(node.getRight());
    System.out.println(node.toString());
  }

  private void preorderAdd(ArrayList<T> list, Node<T> node) {
    if (node == null) {
      return;
    }

    list.add(node.getValue());
    preorderAdd(list, node.getLeft());
    preorderAdd(list, node.getRight());

  }

  public static boolean insertTest() {
    RBTree<Bread> bt = new RBTree<Bread>();
    
    bt.insert(new Bread(20, "SourDough"));
    bt.insert(new Bread(25, "SourDough"));
    bt.insert(new Bread(23, "SourDough"));
    
    ArrayList<Bread> breadList = new ArrayList<Bread>();
    
    bt.preorderAdd(breadList, bt.getRoot());
    
    if(breadList.get(0).compareTo(new Bread(23, "SourDough")) != 0){
      return false;
    }
    
    if(breadList.get(1).compareTo(new Bread(20, "SourDough")) != 0){
      return false;
    }
    
    if(breadList.get(2).compareTo(new Bread(25, "SourDough")) != 0){
      return false;
    }
    
    return true;
  }

  public static void main(String[] args) {
    RBTree<Bread> bt = new RBTree<Bread>();

    // left rotate
    System.out.println("left rotate --");
    bt.insert(new Bread(10, "SourDough"));
    bt.insert(new Bread(25, "SourDough"));
    bt.insert(new Bread(32, "SourDough"));
    bt.printTree(bt.getRoot());

    // right rotate
    bt = new RBTree<Bread>();
    System.out.println("right rotate --");
    bt.insert(new Bread(10, "SourDough"));
    bt.insert(new Bread(5, "SourDough"));
    bt.insert(new Bread(2, "SourDough"));
    bt.printTree(bt.getRoot());

    // left-right rotate
    bt = new RBTree<Bread>();
    System.out.println("left-right rotate --");
    bt.insert(new Bread(10, "SourDough"));
    bt.insert(new Bread(5, "SourDough"));
    bt.insert(new Bread(7, "SourDough"));
    bt.printTree(bt.getRoot());

    // right-left rotate
    bt = new RBTree<Bread>();
    System.out.println("right-left rotate --");
    bt.insert(new Bread(20, "SourDough"));
    bt.insert(new Bread(25, "SourDough"));
    bt.insert(new Bread(23, "SourDough"));
    bt.printTree(bt.getRoot());

    System.out.println("Pre-order Traversal --");
    bt.printPreorderTraversal(bt.getRoot());
    System.out.println("In-order Traversal --");
    bt.printInorderTraversal(bt.getRoot());
    System.out.println("Post-order Traversal --");
    bt.printPostorderTraversal(bt.getRoot());
    
    System.out.println();
    System.out.println(insertTest());
  }

}
