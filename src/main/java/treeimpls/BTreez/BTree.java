package treeimpls.BTreez;

public class BTree<T extends Comparable<T>> {
  private Node<T> root;
  private int order;
  private int height = 0;

  public BTree(int order) {
    this.root = null;
    this.order = order;
  }

  private Node<T> getRoot() {
    return root;
  }

  public void insert(T o) {
    Node<T> afterInsertRoot = insertHelper(getRoot(), o);

    if (null != root && root != afterInsertRoot)
      height++;

    root = afterInsertRoot;

  }

  public Node<T> insertHelper(Node<T> node, T o) {
    // if node equal to null, set root
    if (node == null) {
      node = new Node<T>(order);
      node.addKey(o);
      return node;
    }

    // check if node is leaf, if yes, add key
    if (node.isLeaf()) {
      node.addKey(o);
      // check if node needs to be split
      if (node.getKeySize() == node.getMAX_KEYS() + 1) {
        // checks if node needs to be split
        node = split(node, null, null);
      }
    } else {
      // find which node to go
      int index = 0;
      while (index < node.getKeySize()) {
        if (node.getKey(index).compareTo(o) == 1 || node.getKey(index).compareTo(o) == 0) {
          break;
        }
        index++;
      }

      // recurse now
      Node<T> recurseOnNode = node.getChild(index);
      Node<T> insertedNode = insertHelper(node.getChild(index), o);
      if (recurseOnNode != insertedNode) {
        // split happened

        node.addKey(insertedNode.getKey(0));

        if (node.getKeySize() == node.getMAX_KEYS() + 1) {
          // parent has NO space to accommodate split
          node = split(node, recurseOnNode, insertedNode);
        } else {
          // check for space to add child to parent node

          node.setChild(index, insertedNode.getChild(0));
          if (node.getChild(index + 1) == null) {
            node.addChild(insertedNode.getChild(1));
          } else {
            // addShiftChild() method would be called here
            node.shiftAddChild(index+1, insertedNode.getChild(1));
          }
        }
      }
    }

    return node;
  }

  public Node<T> split(Node<T> node, Node<T> ogChild, Node<T> splitChild) {
    T[] keys = node.getKeys();
    int midIndex = node.getKeySize() / 2;

    Node<T> parentNode = new Node<T>(order);
    parentNode.addKey(keys[midIndex]);
    parentNode.setParent(node.getParent());
    parentNode.setLeaf(false);

    
    Node<T> left = new Node<T>(order);
    for(int i = 0; i < midIndex; i++) {
      left.addKey(node.getKey(i));
    }
    
    Node<T> right = new Node<T>(order);
    for(int j = midIndex+1; j < node.getKeySize(); j++) {
      right.addKey(node.getKey(j));
    }
    
    if(node.getChildrenSize() > 0) {
      left.setLeaf(false);
      right.setLeaf(false);
      
      Node<T> childToAdd = left;
      
      int c = 0;
      while(c < node.getChildrenSize()) {
        Node<T> child = node.getChild(c);
        if(parentNode.getKey(0).compareTo(child.getKey(0)) == -1) {
          childToAdd = right;
        }
        
        if(ogChild != null && child == ogChild) {
          childToAdd.addChild(splitChild.getChild(0));
          childToAdd.addChild(splitChild.getChild(1));
        } else {
          childToAdd.addChild(child);
        }
        c++;
      }
    } 
    
    parentNode.addChild(left);
    parentNode.addChild(right);
    return parentNode;
  }

  public void printNode(Node<T> node) {
    T[] keys = node.getKeys();
    int i = 0;
    while (i < node.getKeySize()) {
      System.out.print(keys[i].toString() + " ");
      i++;
    }
  }

  public void printTree() {
    Node<T>[] children = root.getChildren();

    printNode(root);
    int i = 0;
    while (i < root.getChildrenSize()) {
      System.out.println("children");
      printNode(children[i]);
      i++;
    }
  }

  public String toString() {
    return toString(root, height, "") + "\n";
  }

  private String toString(Node node, int ht, String indent) {
    StringBuilder s = new StringBuilder();
    Node[] children = node.getChildren();

    if (ht == 0) {
      s.append(indent);
      s.append("[");
      for (int i = 0; i < node.getKeySize(); i++) {
        s.append(node.getKey(i));
        if (i != node.getKeySize() - 1)
          s.append(",");
      }
      s.append("]");
      s.append("\n");
    } else {
      for (int j = node.getChildrenSize() - 1; j >= 0; j--) {
        if (j <= 0) {
          s.append(indent);
          s.append("(");
          for (int p = 0; p < node.getKeySize(); p++) {
            s.append(node.getKey(p));
            if (p != node.getKeySize() - 1)
              s.append(",");
          }
          s.append(")");
          s.append("\n");

        }
        Node nextChild = node.getChildren()[j];
        s.append(toString(nextChild, ht - 1, indent + "\t"));

      }
    }

    return s.toString();
  }


  public static void main(String[] args) {
    BTree<Bread> bt = new BTree<Bread>(1);
    bt.insert(new Bread(15, "italian"));
    System.out.println(bt);


    bt.insert(new Bread(17, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(19, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(21, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(22, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(13, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(12, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(25, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(27, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(29, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(31, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(8, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(5, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(3, "italian"));
    System.out.println(bt);
    bt.insert(new Bread(1, "italian"));
    System.out.println(bt);
    // bt.printTree();
  }


}

