package treeimpls.Graphz;

public class Edge<T extends Comparable<T>, W extends Comparable> {
  private GraphNode<T,W> from;
  private GraphNode<T,W> to;
  private W weight;
  private boolean isDirected;

  public Edge(GraphNode<T,W> from, GraphNode<T,W> to, W weight, boolean isDirected) {
    this.from = from;
    this.to = to;
    this.weight = weight;
    this.isDirected = isDirected;
  }

  public Edge(GraphNode<T,W> from, GraphNode<T,W> to) {
    this.from = from;
    this.to = to;
  }

  public Edge(GraphNode<T,W> from, GraphNode<T,W> to, boolean isDirected) {
    this.from = from;
    this.to = to;
    this.isDirected = isDirected;
  }

  public Edge(GraphNode<T,W> from, GraphNode<T,W> to, W weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }

  public GraphNode<T,W> getFrom() {
    return from;
  }

  public void setFrom(GraphNode<T,W> from) {
    this.from = from;
  }

  public GraphNode<T,W> getTo() {
    return to;
  }

  public void setTo(GraphNode<T,W> to) {
    this.to = to;
  }

  public W getWeight() {
    return weight;
  }

  public void setWeight(W weight) {
    this.weight = weight;
  }

  public boolean isDirected() {
    return isDirected;
  }

  public void setDirected(boolean isDirected) {
    this.isDirected = isDirected;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((from == null) ? 0 : from.hashCode());
    result = prime * result + (isDirected ? 1231 : 1237);
    result = prime * result + ((to == null) ? 0 : to.hashCode());
    result = prime * result + ((weight == null) ? 0 : weight.hashCode());
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(from).append((isDirected ? " --> " : " --- ")).append(to).append(" (")
        .append((weight != null ? weight : "")).append(")");
    return builder.toString();
  }

  public static void main(String[] args) {
    Edge<String, Integer> e =
        new Edge<String, Integer>(new GraphNode<String, Integer>("a"), new GraphNode<String, Integer>("b"), 65, true);
    System.out.println(e);
  }
}
