/***
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    private class CacheItem{
        public int key;
        public int value;
        public CacheItem prev;
        public CacheItem next;
        public CacheItem(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<CacheItem> bidirectionalList;
    private HashMap<Integer, CacheItem> map;
    private int capacity = 10;
    private int cache_used = 0;
    private CacheItem head;

    private void mvToHead(CacheItem item){
        item.next = head.next;
        head.next.prev = item;
        head.next = item;
        item.prev = head;
    }

    private void addItem(CacheItem item){
        mvToHead(item);
        map.put(item.key, item);
        bidirectionalList.add(item);
        cache_used++;
    }

    private int removeLastItem() {
        CacheItem last  = head.prev;
        last.prev.next = head;
        head.prev = last.prev;
        map.remove(last.key);
        cache_used--;
        return last.key;
    }

    public LRUCache(int capacity) {
        bidirectionalList = new ArrayList<CacheItem>();
        map = new HashMap<Integer, CacheItem>();
        head = new CacheItem(Integer.MIN_VALUE, Integer.MIN_VALUE);
        head.prev = head;
        head.next = head;

        this.capacity = capacity;
    }

    public int get(int key) {
        CacheItem item = map.get(key);
        if (item == null)
            return -1;
        else {

            item.next.prev = item.prev;
            item.prev.next = item.next;

            mvToHead(item);
            return item.value;
        }
    }

    public void set(int key, int value) {
        if (bidirectionalList.isEmpty()) {
            CacheItem item = new CacheItem(key, value);
            addItem(item);
            return;
        }

        CacheItem item = map.get(key);
        if (item != null) {
            item.value = value;
            item.next.prev = item.prev;
            item.prev.next = item.next;
            mvToHead(item);
        } else{
            if(cache_used < capacity) {
                item = new CacheItem(key, value);
                addItem(item);
            } else {
                removeLastItem();
                item = new CacheItem(key, value);
                addItem(item);
            }
        }
    }

    public static void main(String args[]) {
        LRUCache lrucache = new LRUCache(5);

        for (int i = 0; i < 10; i++){ 
            lrucache.set(i, i+1);
        }
    //    lrucache.set(5, 11);
        for (int i = 0; i < 10; i++) {
            System.out.printf("key %d, value %d\n", i, lrucache.get(i));
        }
    }
}
