package treeimpls.RBTreez;

public class Node<T extends Comparable<T>> {
  private T value;
  private char color;
  private Node<T> left;
  private Node<T> right;
  private Node<T> parent;
  
  public Node(T value) {
    this.value = value;
    color = 'r';
    left = right = parent = null;
  }
  
  public Node<T> getRight(){
    return right;
  }
  
  public Node<T> getLeft(){
    return left;
  }
  
  public Node<T> getParent(){
    return parent;
  }
  
  public void setRight(Node<T> right){
    this.right = right;
  }
  
  public void setLeft(Node<T> left){
    this.left = left;
  }
  
  public void setParent(Node<T> parent){
    this.parent = parent;
  }
  
  public T getValue() {
    return value;
  }
  
  public char getColor() {
    return color;
  }
  
  public void setColor(char c) {
    color = c;
  }
  
  public String toString() {
    return "<Node: " + getValue() + (left != null ? " L" : "" + (right != null ? " R" : "") +" color:" + getColor() + ">");
  }
}
