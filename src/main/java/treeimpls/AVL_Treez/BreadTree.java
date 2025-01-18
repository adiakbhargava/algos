package treeimpls.AVL_Treez;

public class BreadTree {
    private Node<Bread> root;

    public BreadTree() {
        this.root = null;
    }

    private Node<Bread> getRoot() {
        return root;
    }

    private void updateHeight(Node<Bread> node) {
        int leftHeight = (node.getLeft() == null ? -1 : node.getLeft().getHeight());
        int rightHeight = (node.getRight() == null ? -1 : node.getRight().getHeight());
        node.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    private int getBalanceFactor(Node<Bread> node) {
        int leftHeight = (node.getLeft() == null ? -1 : node.getLeft().getHeight());
        int rightHeight = (node.getRight() == null ? -1 : node.getRight().getHeight());

        return leftHeight - rightHeight;
    }

    public Node<Bread> search(Bread o) {
        int cmp = root.getValue().compareTo(o);
        if (cmp == 0) {
            return root;
        }

        if (cmp == -1 && root.getRight() == null) {
            return null;
        }

        if (cmp == 1 && root.getLeft() == null) {
            return null;
        }

        if (cmp == -1) {
            return search(root.getRight().getValue());
        } else {
            return search(root.getLeft().getValue());
        }
    }

    public void insertLoaf(Bread loaf) {
        // if (root == null) {
        // root = new Node<Bread>(loaf);
        // return root;
        // }

        root = insertHelper(getRoot(), loaf);
        // root = insertIgnoreRotations(getRoot(), loaf);
    }

    private Node<Bread> insertHelper(Node<Bread> node, Bread loaf) {
        if (node == null) {
            return new Node<Bread>(loaf);
        }

        int cmp = loaf.compareTo(node.getValue());
        if (cmp == -1) {
            node.setLeft(insertHelper(node.getLeft(), loaf));
        } else if (cmp == 1) {
            node.setRight(insertHelper(node.getRight(), loaf));
        } else if (cmp == 0) {
            // duplicates are not allowed
            return node;
        }

        updateHeight(node);

        int bf = getBalanceFactor(node);

        if (bf == 2) {
            System.out.println("Before Rotation --");
            printTree(getRoot());
            if (node.getLeft().getValue().compareTo(loaf) == 1) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (bf == -2) {
            System.out.println("Before Rotation --");
            printTree(getRoot());

            if (node.getRight().getValue().compareTo(loaf) == -1) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }

            // if (bf < -1 && cmp == 1) {
            // if (node.getRight().getLeft() != null) {
            // node.setRight(rotateRight(node.getRight()));
            // node = rotateLeft(node);
            // } else {
            // node = rotateLeft(node);
            // }
            //
            // } else if (bf > 1 && cmp == -1) {
            // if (node.getLeft().getRight() != null) {
            // node.setLeft(rotateLeft(node.getLeft()));
            // node = rotateRight(node);
            // } else {
            // node = rotateRight(node);
            // }
            // } else if (bf < -1 && cmp == 1) {
            // node.setRight(rotateRight(node.getRight()));
            // node = rotateLeft(node);
        }

        // return node
        return node;
    }

    public Bread getSuccessor(Node<Bread> node) {
        if (node.getLeft() != null) {
            getSuccessor(node.getLeft());
        }

        return node.getValue();
    }

    public void deleteLoaf(Bread loaf) {
        root = deleteLoafHelper(getRoot(), loaf);
    }

    public Node<Bread> deleteLoafHelper(Node<Bread> node, Bread loaf) {
        if (node == null) {
            return null;
        }

        int cmp = loaf.compareTo(node.getValue());
        if (cmp == -1) {
            node.setLeft(deleteLoafHelper(node.getLeft(), loaf));
        } else if (cmp == 1) {
            node.setRight(deleteLoafHelper(node.getRight(), loaf));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                root = null;
                return root;
            }

            if (node.getRight() == null) {
                Node<Bread> temp = node.getLeft();
                node = null;
                return temp;
            } else if (node.getLeft() == null) {
                Node<Bread> temp = node.getRight();
                node = null;
                return temp;
            } else {
                Node<Bread> successor = new Node<Bread>(getSuccessor(node.getRight()));
                successor.setLeft(node.getLeft());
                successor.setRight(node.getRight());
                node = successor;
                node.setRight(deleteLoafHelper(node.getRight(), successor.getValue()));
            }
        }

        updateHeight(node);
        int bf = getBalanceFactor(node);
        if (bf < -1 && getBalanceFactor(node.getRight()) <= 0) {
            return rotateLeft(node);
        } else if (bf > 1 && getBalanceFactor(node.getLeft()) >= 0) {
            return rotateRight(node);
        } else if (bf < -1 && getBalanceFactor(root.getRight()) > 0) {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        } else if (bf > 1 && getBalanceFactor(root.getLeft()) < 0) {
            node.setLeft(rotateRight(node.getLeft()));
            return rotateRight(node);
        }

        return node;
    }

    public Node<Bread> rotateLeft(Node<Bread> node) {
        // System.out.println("rotate left");

        Node<Bread> temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);

        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    public Node<Bread> rotateRight(Node<Bread> node) {
        // System.out.println("rotate right");

        Node<Bread> temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);

        updateHeight(node);
        updateHeight(temp);

        return temp;
    }

    private static void printTree(Node<Bread> node) {

        TreePrinter<Node<Bread>> printer = new TreePrinter<>(
                n -> "" + n.getValue() + ", h-" + n.getHeight(), n -> n.getLeft(), n -> n.getRight());
        printer.setHspace(1);
        printer.setSquareBranches(false);
        printer.setLrAgnostic(true);
        printer.printTree(node);
        System.out.println();
    }

    public Node<Bread> insertIgnoreRotations(Node<Bread> node, Bread loaf) {
        if (node == null) {
            return new Node<Bread>(loaf);
        }

        int cmp = loaf.compareTo(node.getValue());
        if (cmp == -1) {
            node.setLeft(insertHelper(node.getLeft(), loaf));
        } else if (cmp == 1) {
            node.setRight(insertHelper(node.getRight(), loaf));
        }

        updateHeight(node);
        return node;
    }

    public static void main(String[] args) {

        // what is this scenario? ; rotate left or right
        BreadTree bt = new BreadTree();
        // Bread loaf = new Bread(120, "Rye");
        //
        // bt.insertLoaf(new Bread(50, "Rye"));
        // bt.insertLoaf(new Bread(25, "Rye"));
        // bt.insertLoaf(new Bread(75, "Rye"));
        // bt.insertLoaf(new Bread(15, "Rye"));
        // bt.insertLoaf(new Bread(35, "Rye"));
        // bt.insertLoaf(new Bread(10, "Rye"));
        // bt.insertLoaf(new Bread(60, "Rye"));
        // bt.insertLoaf(new Bread(120, "Rye"));
        // bt.insertLoaf(new Bread(68, "Rye"));
        // bt.insertLoaf(new Bread(90, "Rye"));
        // bt.insertLoaf(new Bread(125, "Rye"));
        // bt.insertLoaf(new Bread(83, "Rye"));
        // bt.insertLoaf(new Bread(100, "Rye"));
        //
        // bt.deleteLoaf(loaf);
        // loaf = new Bread(10, "Rye");
        // bt.deleteLoaf(loaf);

        // right rotate
        System.out.println("right rotate --");
        bt.insertLoaf(new Bread(10, "SourDough"));
        bt.insertLoaf(new Bread(5, "SourDough"));
        bt.insertLoaf(new Bread(2, "SourDough"));
        printTree(bt.getRoot());

        // left rotate
        bt = new BreadTree();
        System.out.println("left rotate --");
        bt.insertLoaf(new Bread(10, "SourDough"));
        bt.insertLoaf(new Bread(25, "SourDough"));
        bt.insertLoaf(new Bread(32, "SourDough"));
        printTree(bt.getRoot());


//    // left-right rotate
//    bt = new BreadTree();
//    System.out.println("left-right rotate --");
//    bt.insertLoaf(new Bread(10, "SourDough"));
//    bt.insertLoaf(new Bread(5, "SourDough"));
//    bt.insertLoaf(new Bread(7, "SourDough"));
//    printTree(bt.getRoot());
//
//    // right-left rotate
//    bt = new BreadTree();
//    System.out.println("right-left rotate --");
//    bt.insertLoaf(new Bread(20, "SourDough"));
//    bt.insertLoaf(new Bread(25, "SourDough"));
//    bt.insertLoaf(new Bread(23, "SourDough"));
//    printTree(bt.getRoot());
    }

}
