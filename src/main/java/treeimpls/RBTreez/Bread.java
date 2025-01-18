package treeimpls.RBTreez;

public class Bread implements Comparable<Bread>{
  private int value;
  private String name;
  
  public Bread(int value, String name) {
    this.value = value;
    this.name = name;
  }
  
  public int getBreadValue() {
    return value;
  }
  
  public String getName() {
    return name;
  }
  
  public int compareTo(Bread o) {
    int cmp = this.getBreadValue() - o.getBreadValue();
    
    return (cmp < 0) ? -1 : ((cmp == 0) ? 0 : 1);
  }
  
  public String toString() {
    return "[" + getName() + " " + getBreadValue() + "]";
  }
}
