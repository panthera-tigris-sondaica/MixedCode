import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashMapCustom<K, V> {
    private class HashNode {
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private LinkedList<HashNode>[] bucket;

    public HashMapCustom(int n) {
        this.size = 0;
        initBucketArr(4);
    }

    private void initBucketArr(int n) {
        bucket = new LinkedList[n];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    public V put(K key, V value) {
        int bi = hashfn(key);
        int di = findIndexWithinBucket(key, bi);
        V temp = null;
        if (di == -1) {
            HashNode node = new HashNode(key, value);
            bucket[bi].add(node);
            size++;
        } else {
            HashNode node = bucket[bi].get(di);
            temp = node.value;
            node.value = value;
        }
        double lambda = size * 1.0 / bucket.length;
        if (lambda > 2.0) {
            rehash();
        }
        return temp;
    }

    private void rehash() {
        LinkedList<HashNode>[] temp = bucket;
        initBucketArr(2 * temp.length);
        size = 0;
        for (int i = 0; i < temp.length; i++) {
            for (HashNode n : temp[i])
                put(n.key, n.value);
        }
    }

    public V get(K key) {
        int hc = hashfn(key);
        int di = findIndexWithinBucket(key, hc);
        if (di != -1) {
            HashNode n = bucket[hc].get(di);
            return n.value;
        } else return null;
    }


    public boolean containsKey(K key) {
        int hc = hashfn(key);
        int di = findIndexWithinBucket(key, hc);
        if (di != -1) {
            return false;
        } else return true;
    }


    public V remove(K key) {
        int hc = hashfn(key);
        int di = findIndexWithinBucket(key, hc);
        if (di != -1) {
            HashNode node = bucket[hc].remove(di);
            size--;
            return node.value;
        } else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public Set<K> keySet() {
        Set<K> ll = new HashSet<>();
        for (int i = 0; i < bucket.length; i++) {
            for (HashNode node : bucket[i]) {
                ll.add(node.key);
            }
        }
        return ll;
    }

    public void display() {
        for (int i = 0; i < bucket.length; i++) {
            for (HashNode node : bucket[i]) {
                System.out.println(node.key + "  " + node.value);
            }
        }
    }

    private int hashfn(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % bucket.length;
    }

    private int findIndexWithinBucket(K key, int bi) {
        int di = 0;
        for (HashNode Node : bucket[bi]) {
            if (Node.key.equals(key))
                return di;
            di++;
        }
        return -1;
    }

}

