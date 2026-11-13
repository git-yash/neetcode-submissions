class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    Node start;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap();
        this.start = new Node(-1, -1);
        this.end = new Node(-1, -1);

        this.start.next = end;
        this.end.prev = start;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev; 
    }

    private void addToEnd(Node node) {
        Node prev = end.prev;
        prev.next = node;
        node.prev = prev;
        end.prev = node;
        node.next = end;
    }

    private void nodeGotUsed(Node node) {
        remove(node);
        addToEnd(node);
    }

    private void capacityCheck(){
        if(cache.size() > capacity) {
            Node lru = start.next;
            cache.remove(lru.key);
            this.remove(lru);
        }
    }

    private boolean updateIfExists(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = value;
            this.nodeGotUsed(node);

            return true;
        }

        return false;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {return -1;}

        Node node = cache.get(key);
        this.nodeGotUsed(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(updateIfExists(key, value)) {return;}

        Node node = new Node(key, value);
        this.addToEnd(node);
        cache.put(key, node);

        capacityCheck();
    }
}
