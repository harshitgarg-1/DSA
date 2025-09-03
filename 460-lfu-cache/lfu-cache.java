import java.util.HashMap;
import java.util.Map;

class LFUCache {

    private final int capacity;
    private int size;
    private int minFrequency;

    // Maps a key to its node
    private final Map<Integer, Node> keyToNode;
    // Maps a frequency to a doubly linked list of nodes
    private final Map<Integer, DoublyLinkedList> frequencyToNodes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.frequencyToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            // update value and frequency
            Node node = keyToNode.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if (size == capacity) {
            evictLeastFrequentlyUsed();
        }

        // create new node with frequency 1
        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);
        frequencyToNodes
                .computeIfAbsent(1, f -> new DoublyLinkedList())
                .addNode(newNode);

        size++;
        minFrequency = 1; // new node has freq 1
    }

    // ------------ Helper Methods ------------

    private void increaseFrequency(Node node) {
        int currentFreq = node.frequency;
        DoublyLinkedList currentList = frequencyToNodes.get(currentFreq);
        currentList.removeNode(node);

        // if this node was the last in the minFrequency list, increase minFrequency
        if (currentFreq == minFrequency && currentList.isEmpty()) {
            minFrequency++;
        }

        node.frequency++;
        frequencyToNodes
                .computeIfAbsent(node.frequency, f -> new DoublyLinkedList())
                .addNode(node);
    }

    private void evictLeastFrequentlyUsed() {
        DoublyLinkedList list = frequencyToNodes.get(minFrequency);
        Node nodeToRemove = list.removeFirst();
        keyToNode.remove(nodeToRemove.key);
        size--;
    }

    // ------------ Internal Classes ------------

    private static class Node {
        int key, value, frequency;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private static class DoublyLinkedList {
        private final Node head;
        private final Node tail;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            // always add to the end (before tail)
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeFirst() {
            if (isEmpty()) return null;
            Node first = head.next;
            removeNode(first);
            return first;
        }

        boolean isEmpty() {
            return head.next == tail;
        }
    }
}

