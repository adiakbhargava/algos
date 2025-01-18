package treeimpls.Graphz;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>, W extends Comparable> {
  private ArrayList<GraphNode<T, W>> nodes;


  public Graph(ArrayList<GraphNode<T, W>> nodes) {
    this.nodes = nodes;
  }

  public void dfs(GraphNode<T, W> n) {
    n.setVisited(true);
    // System.out.println(n.toString());
    for (Edge<T, W> e : n.getOutgoingEdges()) {
      System.out.println(e);
      GraphNode<T, W> successor = e.getTo();

      if (!successor.getVisited()) {
        dfs(successor);
      }
    }
  }
  
  public static void main(String[] args) {
    //Integer i1 = new Integer(302);
    //GraphNode<Integer> n1 = new GraphNode<Integer>(i1);
  }

}
