package linkedlists;

import java.util.HashMap;

public class LRUCache {

    // DoublyLinkedListNode - used to store key, val, prev , next. it ia a component of DoublyLinkedList which is used for tracking recently used entries.
    // head of the list - LRU node , tail of the list - MRU node
    private static class DoublyLinkedListNode {
        int val;
        int key;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(){}
        DoublyLinkedListNode(int key, int val){
            this.val = val;
            this.key = key;
        }
        DoublyLinkedListNode(int val, DoublyLinkedListNode next, DoublyLinkedListNode prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    // Cache Implementation
    // init the LRU cache constructor; it initializes the hashmap based cache of a given capacity and the doubly linked list to track the recentness of an entry
    private static int capacity;
    private HashMap<Integer, DoublyLinkedListNode> cacheMap;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cacheMap = new HashMap<Integer, DoublyLinkedListNode>(capacity);
        head = new DoublyLinkedListNode(-1,-1);
        tail = new DoublyLinkedListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    // retrieve an element from the cache for a given key and update the recentess of the entry in the tracking doubly llist
    public int get(int key){
        if(!cacheMap.containsKey(key)){
            return -1; // indicates key not found
        }
        // remove node from tracking llist and add it to its tail (the most recently used node)
        DoublyLinkedListNode keyEntry = cacheMap.get(key);
        removeNode(keyEntry);
        addToTail(keyEntry);

        return keyEntry.val;
    }

    // add an element to the cache for a given key and update the recentness of the entry in the tracking doubly llist
    public void put(int key, int val){
        // if key is found in cacheMap, we update the entry
        if(cacheMap.containsKey(key)){
            removeNode(cacheMap.get(key));
        }
        // update value in cache
        DoublyLinkedListNode node = new DoublyLinkedListNode(key, val);
        cacheMap.put(key, node);

        // if cache is at capacity, remove least recently used node
        if(cacheMap.size() > capacity){
            cacheMap.remove(head.next.key);
            removeNode(head.next);
        }
        // add the node to tail as its most recently accessed node
        addToTail(node);
    }

    private void addToTail(DoublyLinkedListNode node){
        DoublyLinkedListNode prevNode = tail.prev;
        node.prev = prevNode;
        node.next = tail;
        prevNode.next = node;
        tail.prev = node;
    }

    private void removeNode(DoublyLinkedListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }



    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,100);
        cache.put(2,250);
        System.out.println(cache.get(2));
        cache.put(1,275); // update same key with no value
        System.out.println(cache.get(1));
        cache.put(4,300);
        System.out.println("Cache is full --");
        cache.put(3,200);
        System.out.println(cache.get(4));
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2)); // try to get key that was evicted from cache being at full capacity
        System.out.println(cache.get(9)); // try to get non-existant key

        // performance test
        int loopCount = 40000000;
        LRUCache cache1 = new LRUCache(40000000);
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < loopCount; i++){
            cache1.put(i,i);
        }
        System.out.println("Time taken for " + loopCount + " puts is " + (System.currentTimeMillis()-startTime));
    }

}
