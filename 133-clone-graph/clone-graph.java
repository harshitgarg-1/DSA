/*
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> newNodes = new HashMap<>();
        return cloneGraph(node, newNodes);
    }
    public Node cloneGraph(Node node, HashMap<Node, Node> newNodes) {
        if(node == null) return null;
        if(newNodes.containsKey(node)) return newNodes.get(node);
        Node newNode = new Node(node.val);
        newNodes.put(node, newNode);
        for(Node neb : node.neighbors){
            newNode.neighbors.add(cloneGraph(neb, newNodes));
        }
        return newNode;
    }
}