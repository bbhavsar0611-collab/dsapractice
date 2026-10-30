package main.graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph_2 {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    class Solution {

    HashMap<Node, Node> visited = new HashMap<>();
        public Node cloneGraph(Node node) {

            // 1. Handle empty graph
            if (node == null) {
                return null;
            }

            // 2. If already cloned, return the existing clone
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // 3. Create a copy of the current node
            Node clone = new Node(node.val);

            // 4. Store the mapping BEFORE exploring neighbors
            visited.put(node, clone);

            // 5. Clone all neighbors and recreate connections
            for (Node neighbor : node.neighbors) {
                Node clonedNeighbor = cloneGraph(neighbor);
                clone.neighbors.add(clonedNeighbor);
            }

            // 6. Return the cloned node
            return clone;
        }
    }
    }

