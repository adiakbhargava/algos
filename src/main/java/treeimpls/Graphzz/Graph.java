package treeimpls.Graphzz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Graph<T extends Comparable<T>> {
  private static final String IN_PROGRESS = "IN_PROGRESS";

  private static final String DONE = "DONE";

  private ArrayList<GraphNode<T>> nodes;

  public ArrayList<GraphNode<T>> getNodes() {
    return nodes;
  }

  public void setNodes(ArrayList<GraphNode<T>> nodes) {
    this.nodes = nodes;
  }

  public Graph(ArrayList<GraphNode<T>> nodes) {
    this.nodes = nodes;
  }

  public void dfs(GraphNode<T> n) {
    n.setVisited(true);
    System.out.println(n);
    for (GraphNode<T> m : n.getSuccessors()) {
      if (!m.getVisited()) {
        dfs(m);
      }
    }
  }

  public boolean contains(GraphNode<T> n) {
    if (nodes != null && n != null && nodes.contains(n)) {
      return true;
    }

    return false;
  }

  public ArrayList<GraphNode<T>> dfsWithPrint(GraphNode<T> n) {
    System.out.println("--dfs traversal starting @ [" + n + "]");
    if (!contains(n)) {
      return null;
    }

    ArrayList<GraphNode<T>> list = dfsWithPrintHelper(n, "", new ArrayList<GraphNode<T>>());

    resetAll();
    return list;
  }

  public ArrayList<GraphNode<T>> dfsWithPrintHelper(GraphNode<T> n, String indent,
      ArrayList<GraphNode<T>> result) {
    n.setVisited(true);
    System.out.println(indent + n);
    result.add(n);
    for (GraphNode<T> m : n.getSuccessors()) {
      if (!m.getVisited()) {
        dfsWithPrintHelper(m, indent + "--->", result);

      } else {
        System.out.println(indent + "av-" + m);
      }

    }

    return result;
  }

  public void resetAll() {
    for (GraphNode<T> n : nodes) {
      n.setVisited(false);
      if (!n.getVisited()) {
      }
    }
  }

  public boolean pathExists(GraphNode<T> j, GraphNode<T> k) {
    resetAll();
    dfs(j);
    if (k.getVisited()) {
      return true;
    } else {
      return false;
    }
  }

  public void bfs(GraphNode<T> n) {
    Queue<GraphNode<T>> queue = new ArrayDeque<GraphNode<T>>();

    n.setVisited(true);
    queue.add(n);
    while (!queue.isEmpty()) {
      GraphNode<T> current = queue.remove();
      for (GraphNode<T> k : current.getSuccessors()) {

        if (!k.getVisited()) {
          k.setVisited(true);
          queue.add(k);
        } // end if k not visited
      } // end for every successor k
    } // end while queue not empty
  }

  public ArrayList<GraphNode<T>> bfsWithPrint(GraphNode<T> node) {


    System.out.println("--bfs traversal starting @ [" + node + "]");
    if (!contains(node)) {
      return null;
    }

    ArrayList<GraphNode<T>> list = bfsWithPrintHelper(node, "", new ArrayList<GraphNode<T>>());

    resetAll();
    return list;
  }

  public ArrayList<GraphNode<T>> bfsWithPrintHelper(GraphNode<T> node, String indent,
      ArrayList<GraphNode<T>> result) {
    Queue<GraphNode<T>> successorQueue = new ArrayDeque<GraphNode<T>>();

    node.setVisited(true);
    System.out.println(indent + node);
    indent += "--->";
    result.add(node);

    successorQueue.add(node);
    while (!successorQueue.isEmpty()) {
      GraphNode<T> currNode = successorQueue.remove();
      
      
      for (GraphNode<T> successor : currNode.getSuccessors()) {
        if (!successor.getVisited()) {
          successor.setVisited(true);
          System.out.println(indent + successor);
          
          result.add(successor);
          successorQueue.add(successor);
        }
      }
      if(!currNode.getSuccessors().isEmpty()) {
      indent += "--->";
      }
    }

    return result;
  }

  public int topNum(GraphNode<T> node, int size) throws CycleException {
    node.setMark(IN_PROGRESS);
    for (GraphNode<T> successor : node.getSuccessors()) {

      if (successor.getMark() == IN_PROGRESS) {
        // no topological ordering for a cyclic graph!
        throw new CycleException();
      }
      if (successor.getMark() != DONE) {
        size = topNum(successor, size);
      }
    }

    // here when n has no more successors
    node.setMark(DONE);
    node.setTopNum(size);
    return size - 1;
  }

  public static void main(String[] args) throws CycleException {
    //testTopologicalNumbering();
    Graph g = getCoursesGraph();
    ArrayList<GraphNode<Integer>> nodes = g.getNodes();
    
    System.out.println(g.dfsWithPrint(nodes.get(0)));
    
  }

  public static void testTopologicalNumbering() throws CycleException {
    Graph g = getCoursesGraph();
    ArrayList<GraphNode<Integer>> nodes = g.getNodes();

    // g.resetAll();
    // g.topNum((GraphNode) nodes.get(0), nodes.size());
    //
    // nodes.sort((o1, o2) -> {
    // return Integer.compare(o1.getTopNum(), o2.getTopNum());
    // });
    //
    // nodes.forEach(x -> System.out.println(x.toString() + ", " + x.getTopNum()));



  }

  public static Graph getCoursesGraph() {
    // CS 400 graph courses --
    //GraphNode<Integer> g0 = new GraphNode<Integer>(310);
    
    GraphNode<Integer> g1 = new GraphNode<Integer>(0);
    GraphNode<Integer> g2 = new GraphNode<Integer>(2);
    GraphNode<Integer> g3 = new GraphNode<Integer>(3);
    GraphNode<Integer> g4 = new GraphNode<Integer>(1);
    GraphNode<Integer> g5 = new GraphNode<Integer>(4);
    //GraphNode<Integer> g6 = new GraphNode<Integer>(577);

    ArrayList<GraphNode<Integer>> g1Successors = new ArrayList<GraphNode<Integer>>();
    g1Successors.add(g2);
    g1Successors.add(g5);

    ArrayList<GraphNode<Integer>> g2Successors = new ArrayList<GraphNode<Integer>>();
    g2Successors.add(g3);
    //g2Successors.add(g4);

    ArrayList<GraphNode<Integer>> g3Successors = new ArrayList<GraphNode<Integer>>();
    g3Successors.add(g4);

    ArrayList<GraphNode<Integer>> g4Successors = new ArrayList<GraphNode<Integer>>();
    g4Successors.add(g1);

    g1.setSuccessors(g1Successors);
    g2.setSuccessors(g2Successors);
    g3.setSuccessors(g3Successors);
    g4.setSuccessors(g4Successors);

    ArrayList<GraphNode<Integer>> list = new ArrayList<GraphNode<Integer>>();
    // list.add(g0);
    list.add(g1);
    list.add(g2);
    list.add(g3);
    list.add(g4);
    list.add(g5);
   // list.add(g6);

    return new Graph(list);


  }

  public static void main1(String[] args) {
    // GraphNode<Integer> g1 = new GraphNode<Integer>(302);
    // GraphNode<Integer> g2 = new GraphNode<Integer>(367);
    // GraphNode<Integer> g3 = new GraphNode<Integer>(354);
    // GraphNode<Integer> g4 = new GraphNode<Integer>(537);
    // GraphNode<Integer> g5 = new GraphNode<Integer>(640);
    // GraphNode<Integer> g6 = new GraphNode<Integer>(577);
    //
    // ArrayList<GraphNode<Integer>> g1Successors = new ArrayList<GraphNode<Integer>>();
    // g1Successors.add(g2);
    // g1Successors.add(g3);
    //
    // ArrayList<GraphNode<Integer>> g2Successors = new ArrayList<GraphNode<Integer>>();
    // g2Successors.add(g6);
    // g2Successors.add(g4);
    //
    // ArrayList<GraphNode<Integer>> g3Successors = new ArrayList<GraphNode<Integer>>();
    // g3Successors.add(g4);
    //
    // ArrayList<GraphNode<Integer>> g4Successors = new ArrayList<GraphNode<Integer>>();
    // g4Successors.add(g5);

    GraphNode<Integer> g1 = new GraphNode<Integer>(0);
    GraphNode<Integer> g2 = new GraphNode<Integer>(1);
    GraphNode<Integer> g3 = new GraphNode<Integer>(2);
    GraphNode<Integer> g4 = new GraphNode<Integer>(3);
    GraphNode<Integer> g5 = new GraphNode<Integer>(4);
    GraphNode<Integer> g6 = new GraphNode<Integer>(7);

    ArrayList<GraphNode<Integer>> g1Successors = new ArrayList<GraphNode<Integer>>();
    g1Successors.add(g3);
    g1Successors.add(g5);

    ArrayList<GraphNode<Integer>> g3Successors = new ArrayList<GraphNode<Integer>>();
    g3Successors.add(g4);

    ArrayList<GraphNode<Integer>> g4Successors = new ArrayList<GraphNode<Integer>>();
    g4Successors.add(g2);
    g4Successors.add(g5);

    ArrayList<GraphNode<Integer>> g2Successors = new ArrayList<GraphNode<Integer>>();
    g2Successors.add(g1);

    g1.setSuccessors(g1Successors);
    g2.setSuccessors(g2Successors);
    g3.setSuccessors(g3Successors);
    g4.setSuccessors(g4Successors);

    ArrayList<GraphNode<Integer>> list = new ArrayList<GraphNode<Integer>>();
    list.add(g1);
    list.add(g2);
    list.add(g3);
    list.add(g4);
    list.add(g5);

    Graph graph = new Graph(list);


    System.out.println(graph.pathExists(g1, g1));

  }

}
