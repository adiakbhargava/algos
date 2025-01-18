package treeimpls.Graphz;

import java.util.ArrayList;

public class GraphNode<T extends Comparable<T>, W extends Comparable> {
  private T data;
  private ArrayList<GraphNode<T,W>> successors;
  private ArrayList<Edge<T,W>> outgoingEdges; // represent adjacent neighbors or outgoing 
  boolean isVisited;
  
  public GraphNode(T data) {
    this.data = data;
    successors = new ArrayList<GraphNode<T,W>>();
    isVisited = false;
  }
  
  public GraphNode(T data, ArrayList<Edge<T,W>> outgoingEdges) {
    this.data = data;
    successors = new ArrayList<GraphNode<T,W>>();
    isVisited = false;
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

  public ArrayList<GraphNode<T,W>> getSuccessors() {
    return successors;
  }

  public void setSuccessors(ArrayList<GraphNode<T,W>> successors) {
    this.successors = successors;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(data);
    return builder.toString();
  }

  public ArrayList<Edge<T,W>> getOutgoingEdges() {
    return outgoingEdges;
  }

  public void setOutgoingEdges(ArrayList<Edge<T,W>> outgoingEdges) {
    this.outgoingEdges = outgoingEdges;
  }
  
  
}
