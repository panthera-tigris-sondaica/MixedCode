package cache.lru;

import java.util.*;

abstract public class RecentlyUsedCache<K,V> {
    static class Node<K,V>{ //Doubly Linked List
        K key;
        V value;
        Node prev;
        Node next;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return "{"+key+":"+value+"}";
        }
    }

    private Map<K,Node<K,V>> cache;
    private int SIZE;
    Node<K,V> head;
    Node<K,V> tail;

    public RecentlyUsedCache(int capacity){
        if(capacity==0) throw new RuntimeException("Capacity can not be 0");
        this.SIZE=capacity;
        cache = new HashMap<>();
        head = new Node<>(null,null);
        tail = new Node<>(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V value){
        if(cache.containsKey(key)){
            Node<K,V> n = cache.get(key);
            if(n!=head.next){
                removeLinks(n);
                makeHead(n);
            }
            n.value=value;
        } else if(cache.size()==SIZE){
            Node<K,V> n = evictNode();
            cache.remove(n.key);
            removeLinks(n);
            addNode(key,value); // why are we adding node instead of adding at head?
        } else{
            addNode(key,value);
        }
    }

    protected abstract Node<K,V> evictNode();

    private void addNode(K key, V value){
        Node<K,V> n = new Node<>(key, value);
        cache.put(key,n);
        makeHead(n);
    }

    private void makeHead(Node<K,V> n){
        head.next.prev = n;
        n.next = head.next;
        n.prev = head;
        head.next = n;
    }

    private void removeLinks(Node<K,V> n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.prev = null;
        n.next = null;
    }

    public V get(K key){
        if(cache.containsKey(key)){
            Node<K,V> n = cache.get(key);
            removeLinks(n);
            makeHead(n);
            return n.value;
        }
        return null;
    }

    public void printCache(){
        Node n = head.next;
        System.out.print("LRU Cache: ");
        while(n!=tail){
            System.out.print(n);
            n = n.next;
            if(n!=tail) System.out.print(" --> ");
        }
        System.out.println(" <END>");
    }
}

class LRUCache<K,V> extends RecentlyUsedCache<K,V>{

    public LRUCache(int capacity) {
        super(capacity);
    }

    @Override
    protected RecentlyUsedCache.Node<K, V> evictNode() {
        return super.tail.prev;
    }
}

class MRUCache<K,V> extends RecentlyUsedCache<K,V>{

    public MRUCache(int capacity) {
        super(capacity);
    }

    @Override
    protected Node<K, V> evictNode() {
        return super.head.next;
    }
}

class LRUExample{
    public static void main(String[] args) {
        RecentlyUsedCache<String, Integer> lru = new MRUCache<>(2);
        lru.put("C",12);
        lru.printCache();
        lru.put("D",16);
        lru.printCache();
        System.out.println("Get: "+lru.get("C"));
        lru.printCache();

        lru.put("E",11);
        lru.printCache();
    }
}
