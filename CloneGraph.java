/***
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 */

/**
 *
 * Definition for undirected graph.

 * class UndirectedGraphNode {

 *     int label;

 *     List<UndirectedGraphNode> neighbors;

 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }

 * };
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    //Solution 1: BFS, iterative
/*    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;

        Queue<UndirectedGraphNode> queueNodes = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queueNodes.add(node);

        while (!queueNodes.isEmpty()) {
            UndirectedGraphNode n = queueNodes.remove();
            if (visited.contains(n))
                continue;
            visited.add(n);
            UndirectedGraphNode clone;
            if (!map.containsKey(n)) {
                clone = new UndirectedGraphNode(n.label);
                map.put(n, clone);
            } else {
                clone = map.get(n);
            }

            for (UndirectedGraphNode child : n.neighbors) {
                queueNodes.add(child);
                UndirectedGraphNode cloneChild;
                if (!map.containsKey(child) {
                    cloneChild = new UndirectedGraphNode(child.label);
                    map.put(child, cloneChild);
                } else {
                    cloneChild = map.get(child);
                }

                clone.neighbors.add(cloneChild);
            }
        }
        return map.get(node);
    }
*/
    // Solution 2: DFS : T: O(n), S: O(n)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;

        Map<UndirectedGraphNode, UndirectedGraphNode> copied = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> order = new LinkedList<UndirectedGraphNode>();
        return clone(node, copied, order);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> copied, LinkedList<UndirectedGraphNode> order) {
        
        // If already copied and is not the last, continue
        if (copied.containsKey(node) && copied.get(node) != order.getLast()) 
            return copied.get(node);
        
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        
        copied.put(node, new_node);
        order.addLast(node);

        for (UndirectedGraphNode child : node.neighbors) {
            new_node.neighbors.add(clone(child, copied, order));
        }

        return new_node;
    }
}
