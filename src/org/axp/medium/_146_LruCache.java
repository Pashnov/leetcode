package org.axp.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/description/
public class _146_LruCache {

    public static void main(String[] args) {
//        _146_LruCache lruCache = new _146_LruCache(2);
//        lruCache.put(1, 1); // cache is {1=1}
//        lruCache.put(2, 2); // cache is {1=1, 2=2}
//        System.out.println(lruCache.get(1));    // return 1
//        lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println(lruCache.get(2));    // returns -1 (not found)
//        lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println(lruCache.get(1));    // return -1 (not found)
//        System.out.println(lruCache.get(3));    // return 3
//        System.out.println(lruCache.get(4));    // return 4


//        _146_LruCache lruCache = new _146_LruCache(1);
//        System.out.println(lruCache.get(6));    // return -1
//        System.out.println(lruCache.get(8));    // return -1
//        lruCache.put(12, 1); // cache is {12=1}
//        System.out.println(lruCache.get(2));    // return -1
//        lruCache.put(15, 11); // cache is {15=11}
//        lruCache.put(5, 2); // cache is {5=2}
//        lruCache.put(1, 15); // cache is {1=15}
//        lruCache.put(4, 2); // cache is {1=15}
//        System.out.println(lruCache.get(4));    // return 2


        // [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
//        _146_LruCache lruCache = new _146_LruCache(3);
//        lruCache.put(1, 1); // cache is {12=1}
//        lruCache.put(2, 2); // cache is {12=1}
//        lruCache.put(3, 3); // cache is {12=1}
//        lruCache.put(4, 4); // cache is {12=1}
//        System.out.println(lruCache.get(4));    // return -4
//        System.out.println(lruCache.get(3));    // return -1
//        System.out.println(lruCache.get(2));    // return -1
//        System.out.println(lruCache.get(1));    // return -1
//        lruCache.put(5, 5); // cache is {12=1}
//        System.out.println(lruCache.get(1));    // return -1
//        System.out.println(lruCache.get(2));    // return -1
//        System.out.println(lruCache.get(3));    // return -1
//        System.out.println(lruCache.get(4));    // return -1
//        System.out.println(lruCache.get(5));    // return -1

        // [[10],[10,13],[3,17],[6,11],[10,5],[9,10],[13],
        // [2,19],[2],[3],[5,25],[8],[9,22],[5,5],[1,30],
        // [11],[9,12],[7],[5],[8],[9],[4,30],[9,3],[9],[10],[10],
        _146_LruCache lruCache = new _146_LruCache(10);
        lruCache.put(10, 13); // cache is {12=1}
        lruCache.put(3, 17); // cache is {12=1}
        lruCache.put(6, 11); // cache is {12=1}
        lruCache.put(10, 5); // cache is {12=1}
        lruCache.put(9, 10); // cache is {12=1}
        System.out.println(lruCache.get(13));    // return -1

        lruCache.put(2, 19); // cache is {12=1}
        System.out.println(lruCache.get(2));    // return -1
        System.out.println(lruCache.get(3));    // return -1
        lruCache.put(5, 25); // cache is {12=1}
        System.out.println(lruCache.get(8));    // return -1
        lruCache.put(9, 22); // cache is {12=1}
        lruCache.put(5, 5); // cache is {12=1}
        lruCache.put(1, 30); // cache is {12=1}

        System.out.println(lruCache.get(11));    // return -1
        lruCache.put(9, 12);
        System.out.println(lruCache.get(7));    // return -1
        System.out.println(lruCache.get(5));    // return -1
        System.out.println(lruCache.get(8));    // return -1
        System.out.println(lruCache.get(9));    // return -1
        lruCache.put(4, 30);
        lruCache.put(9, 3);
        System.out.println(lruCache.get(9));    // return -1
        System.out.println(lruCache.get(10));    // return -1
        System.out.println(lruCache.get(10));    // return -1
        // [6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],
        // [5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],
        lruCache.put(6, 14);
        lruCache.put(3, 1);
        System.out.println(lruCache.get(3));    // return -1
        lruCache.put(10, 11);
        System.out.println(lruCache.get(8));    // return -1
        lruCache.put(2, 14);
        System.out.println(lruCache.get(1));    // return -1
        System.out.println(lruCache.get(5));    // return -1
        System.out.println(lruCache.get(4));    // return -1
        lruCache.put(11, 4);
        lruCache.put(12, 24);

        lruCache.put(5, 18);
        System.out.println(lruCache.get(13));    // return -1
        lruCache.put(7, 23);
        System.out.println(lruCache.get(8));    // return -1
        System.out.println(lruCache.get(12));    // return -1
        lruCache.put(3, 27);
        lruCache.put(2, 12);
        System.out.println(lruCache.get(5));    // return -1
        lruCache.put(2, 9);
        // [13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],
        // [10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],
        lruCache.put(13, 4);
        lruCache.put(8, 18);
        lruCache.put(1, 7);
        System.out.println(lruCache.get(6));    // return -1
        lruCache.put(9, 29);
        lruCache.put(8, 21);
        System.out.println(lruCache.get(5));    // return -1
        lruCache.put(6, 30);
        lruCache.put(1, 12);

        System.out.println(lruCache.get(10));    // return -1
        lruCache.put(4, 15);
        lruCache.put(7, 22);
        lruCache.put(11, 26);
        lruCache.put(8, 17);
        lruCache.put(9, 29);
        System.out.println(lruCache.get(5));    // return -1
        lruCache.put(3, 14);
        lruCache.put(11, 30);
        System.out.println(lruCache.get(12));    // return -1
        // [4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]


    }

    private final int capacity;
    private Map<Integer, Node> storageO1 = new HashMap<>();
    private Node oldest;
    private Node newest;


    public _146_LruCache(int capacity) {
       this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 1) {
            return oldest != null && oldest.key == key ? oldest.value : -1;
        }
        if (storageO1.containsKey(key)) {
            Node updated = storageO1.get(key);
            // access oldest elem, move to newest
            if (updated == oldest) {
                oldest = oldest.next;
                oldest.priv = null;
                newest.next = updated;
                updated.priv = newest;
                newest = updated;
                return updated.value;
            }
            // access newest elem, nothing do
            if (updated == newest) {
                return updated.value;
            }
            // access middle elem, reset links
            updated.next.priv = updated.priv;
            updated.priv.next = updated.next;

            newest.next = updated;
            updated.priv = newest;
            updated.next = null;
            newest = updated;
            return updated.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 1) {
            oldest = new Node(null, null, key, value);
            return;
        }
        if (storageO1.isEmpty()) {
            newest = new Node(null, null, key, value);
            oldest = newest;
            storageO1.put(key, newest);
        } else if (capacity == storageO1.size() && !storageO1.containsKey(key)) {
            removeOldest();
            newest = new Node(newest, null, key, value);
            storageO1.put(key, newest);
        } else if (storageO1.containsKey(key)) { // scenario update value
            Node remove = storageO1.get(key);
            // access oldest elem, move to newest
            if (remove == oldest) {
                oldest = oldest.next;
                oldest.priv = null;
                newest.next = remove;
                remove.priv = newest;
                newest = remove;
                remove.value = value;
                return;
            }
            // access newest element, do nothing
            if (remove == newest) {
                remove.value = value;
                return;
            }
            // middle case
            remove.priv.next = remove.next;
            remove.next.priv = remove.priv;

            newest.next = remove;
            remove.priv = newest;
            remove.next = null;
            newest = remove;
            remove.value = value;
        } else {
            newest = new Node(newest, null, key, value);
            storageO1.put(key, newest);
        }
    }

    private void removeOldest() {
        int key = oldest.key;
        storageO1.remove(key);
        oldest = oldest.next;
        if (oldest != null) {
            oldest.priv = null;
        }
    }

    static class Node {
        Node priv;
        Node next;
        int key;
        int value;

        public Node(Node priv, Node next, int key, int value) {
            this.priv = priv;
            if (priv != null) {
                priv.next = this;
            }
            this.next = next;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "("+key +"," + value+")->" + next;
        }
    }

}
