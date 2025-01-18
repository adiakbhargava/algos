package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphDeepCopy {
    static class GraphNode{
        private int val;
        private List<GraphNode> neighbors;

        public GraphNode(int val){
            this.val = val;
            neighbors = new ArrayList<GraphNode>();
        }
    }
    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(0);
        GraphNode node2 = new GraphNode(1);
        GraphNode node3 = new GraphNode(2);
        GraphNode node4 = new GraphNode(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        node1.neighbors.get(0).neighbors.add(node1);
        node1.neighbors.get(0).neighbors.add(node3);

        node1.neighbors.get(1).neighbors.add(node1);
        node1.neighbors.get(1).neighbors.add(node2);
        node1.neighbors.get(1).neighbors.add(node4);
        node1.neighbors.get(1).neighbors.get(2).neighbors.add(node3);

        GraphNode clonedNode = (new GraphDeepCopy()).graphDeepCopy(node1);
    }

    private GraphNode graphDeepCopy(GraphNode node){
        if(node == null){
            return null;
        }

        return dfs(node, new HashMap<GraphNode, GraphNode>());
    }

    private GraphNode dfs(GraphNode node, HashMap<GraphNode, GraphNode> cloneMap){
        // if node was already cloned, return previously cloned node
        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }

        // clone node and add it to clone map
        GraphNode clonedNode = new GraphNode(node.val);
        cloneMap.put(node, clonedNode);

        // traverse through node's neighbors to connect their clones to current cloned node
        for(GraphNode neighbor : node.neighbors){
            GraphNode clonedNeighbor = dfs(neighbor, cloneMap);
            clonedNode.neighbors.add(clonedNeighbor);
        }

        return clonedNode;
    }
}
