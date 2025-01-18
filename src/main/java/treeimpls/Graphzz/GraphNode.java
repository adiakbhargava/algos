package treeimpls.Graphzz;

import java.util.ArrayList;

public class GraphNode<T extends Comparable<T>> {
  private T data;
  private ArrayList<GraphNode<T>> successors;
  private boolean isVisited;
  private String mark; // used for tracking nodes during traversals
  private int topNum; // topological num

  public GraphNode(T data) {
    this.data = data;
    successors = new ArrayList<GraphNode<T>>();
    isVisited = false;
    topNum = -1;
    mark = "";
  }

  public boolean getVisited() {
    return isVisited;
  }

  public void setVisited(boolean isVisited) {
    this.isVisited = isVisited;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ArrayList<GraphNode<T>> getSuccessors() {
    return successors;
  }

  public void setSuccessors(ArrayList<GraphNode<T>> successors) {
    this.successors = successors;
  }
  
  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }
  
  public int getTopNum() {
    return topNum;
  }

  public void setTopNum(int topNum) {
    this.topNum = topNum;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(data);
    return builder.toString();
  }

}
