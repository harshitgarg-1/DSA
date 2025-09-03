class LFUCache {
    int capacity;
    Map<Integer, LinkedList1> valueReference; // key -> node
    Map<Integer, Pair> frequencies;          // freq -> doubly linked list
    int minFrequency;
    int keyCounts;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueReference = new HashMap<>();
        frequencies = new HashMap<>();
        minFrequency = 0;
        keyCounts = 0;
    }

    public int get(int key) {
        if (!valueReference.containsKey(key)) {
            return -1;
        }
        LinkedList1 curr = valueReference.get(key);
        updateFrequency(curr);
        return curr.value;
    }

    private void updateFrequency(LinkedList1 curr) {
        int freq = curr.frequency;
        // remove from current list
        Pair oldPair = frequencies.get(freq);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        // if this was the only node at minFrequency, update minFrequency
        if (freq == minFrequency && oldPair.head.next == oldPair.tail) {
            minFrequency++;
        }

        // increase frequency
        curr.frequency = freq + 1;
        Pair newPair = frequencies.get(freq + 1);
        if (newPair == null) {
            newPair = new Pair(new LinkedList1(0, 0), new LinkedList1(0, 0));
            newPair.head.next = newPair.tail;
            newPair.tail.prev = newPair.head;
            frequencies.put(freq + 1, newPair);
        }

        // add to the new list (at tail)
        newPair.tail.prev.next = curr;
        curr.prev = newPair.tail.prev;
        curr.next = newPair.tail;
        newPair.tail.prev = curr;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (valueReference.containsKey(key)) {
            LinkedList1 node = valueReference.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (keyCounts == capacity) {
            delete();
        }
        add(key, value);
    }

    private void delete() {
        Pair pair = frequencies.get(minFrequency);
        LinkedList1 nodeToRemove = pair.head.next;

        // remove node from map and list
        valueReference.remove(nodeToRemove.key);
        nodeToRemove.next.prev = pair.head;
        pair.head.next = nodeToRemove.next;

        keyCounts--;
    }

    private void add(int key, int value) {
        LinkedList1 curr = new LinkedList1(key, value);
        curr.frequency = 1;
        valueReference.put(key, curr);
        keyCounts++;
        minFrequency = 1;

        Pair pair = frequencies.get(minFrequency);
        if (pair == null) {
            pair = new Pair(new LinkedList1(0, 0), new LinkedList1(0, 0));
            pair.head.next = pair.tail;
            pair.tail.prev = pair.head;
            frequencies.put(minFrequency, pair);
        }

        // add to frequency 1 list
        pair.tail.prev.next = curr;
        curr.prev = pair.tail.prev;
        curr.next = pair.tail;
        pair.tail.prev = curr;
    }
}

class LinkedList1 {
    LinkedList1 prev, next;
    int key, value, frequency;

    LinkedList1(int k, int v) {
        key = k;
        value = v;
        frequency = 0;
    }
}

class Pair {
    LinkedList1 head, tail;

    Pair(LinkedList1 h, LinkedList1 t) {
        head = h;
        tail = t;
    }
}
