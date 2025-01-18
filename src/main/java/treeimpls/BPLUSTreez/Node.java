package treeimpls.BPLUSTreez;

import java.util.Arrays;

public class Node<T extends Comparable<T>> {
  private T[] keys;
  private Node<T>[] children;
  private boolean isLeaf;
  private Node<T> parent;
  private Node<T> next;
  private int keySize;
  private int childrenSize;
  private int MAX_KEYS;
  private int MAX_CHILDREN;

  public Node(int m) {
    MAX_KEYS = m-1;
    MAX_CHILDREN = m;
    keys = (T[]) new Comparable[MAX_KEYS + 1]; // plus one for ease of programming
    children = new Node[MAX_CHILDREN+1];
    parent = null;
    keySize = 0;
    childrenSize = 0;
    isLeaf = true;
    next = null;
  }

  public T getKey(int index) {
    return keys[index];
  }

  public void addKey(T key) {
    keys[keySize] = key;
    keySize++;
    Arrays.sort(keys, 0, keySize);
  }

  public Node<T> getChild(int index) {
    return children[index];
  }
  
  public void setChild(int index, Node<T> child) {
    children[index] = child;
  }
  
  public void shiftAddChild(int index, Node<T> child) {
    Node temp = children[index];
    children[index] = child;
    children[index + 1] = temp;
    childrenSize++;
  }

  public void addChild(Node<T> child) {
    children[childrenSize] = child;
    childrenSize++;
    // Arrays.sort(children, 0, childrenSize);
  }

  public T[] getKeys() {
    return keys;
  }

  public void setKeys(T[] keys) {
    this.keys = keys;
  }

  public Node<T>[] getChildren() {
    return children;
  }

  public void setChildren(Node<T>[] children) {
    this.children = children;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public void setLeaf(boolean isLeaf) {
    this.isLeaf = isLeaf;
  }

  public Node<T> getParent() {
    return parent;
  }

  public void setParent(Node<T> parent) {
    this.parent = parent;
  }

  public int getKeySize() {
    return keySize;
  }

  public void setKeySize(int keySize) {
    this.keySize = keySize;
  }

  public int getChildrenSize() {
    return childrenSize;
  }

  public void setChildrenSize(int childrenSize) {
    this.childrenSize = childrenSize;
  }
  
  public int getMAX_KEYS() {
    return MAX_KEYS;
  }

  public void setMAX_KEYS(int mAX_KEYS) {
    MAX_KEYS = mAX_KEYS;
  }

  public int getMAX_CHILDREN() {
    return MAX_CHILDREN;
  }

  public void setMAX_CHILDREN(int mAX_CHILDREN) {
    MAX_CHILDREN = mAX_CHILDREN;
  }


  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("node [");
    for (int i = 0; i < keys.length; i++) {
      s.append(keys[i]).append(" ");
    }
    s.append("]");

    return s.toString();
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

}
