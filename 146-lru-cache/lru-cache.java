class LRUCache {
    int capacity;
    Node head;
    HashMap<Integer, Node> hm;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node req = hm.get(key);
        rearrange(req);
        return req.val;
    }
    
    public void put(int key, int value) {
        if(!hm.containsKey(key)){
            if(capacity==0) removelast();
            Node node = new Node();
            node.key = key;
            node.val = value;
            addNode(node);
            capacity--;
            hm.put(key, node);
        } else {
            Node n = hm.get(key);
            n.val = value;
            rearrange(n);
        }
    }

    public void removelast(){
        Node curr = head;
        while(curr.next.next != null) curr = curr.next;
        Node remove = curr.next;
        curr.next = null;
        hm.remove(remove.key);
        capacity++;
    }
    public void rearrange(Node n){
        n.prev.next = n.next;
        if(n.next != null) n.next.prev = n.prev;
        addNode(n);
    }
    public void addNode(Node node){
        node.next = head.next;
        if(node.next != null) node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

class Node {
    int key;
    int val;
    Node next, prev;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */