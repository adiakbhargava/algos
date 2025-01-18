package treeimpls.AVL_Treez;

public class Node<T extends Comparable<T>> {
    private T value;
    private int height;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        this.value = value;
        height = 0;
        left = right = null;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        height = h;
    }

    public String toString() {
        return "<Node: " + getValue() + (left != null ? " L" : "" + (right != null ? " R" : "") + " height:" + getHeight() + ">");
    }
}
