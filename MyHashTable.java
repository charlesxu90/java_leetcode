import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A hash table implementation that uses separate chaining to handle
 * collisions. For the sake of simplicity, all keys are represented as
 * Strings.
 *
 * @param <V> The data type of the values being stored in this hash table
 */

public class MyHashTable <V> {
    // Subclasses used
    public class HashEntry {
        private String key;
        private V value;

        public HashEntry( String key, V value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
    }

    ArrayList<LinkedList<HashEntry>> buckets;
    HashFunction hashFunction;
    int itemCount = 0;

    public MyHashTable(int numBuckets, HashFunction HashFunction) {
        buckets = new ArrayList<LinkedList<HashEntry>>(numBuckets);
        this.hashFunction = hashFunction;

        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new LinkedList<HashEntry>());
        }
    }

    public void put (String key, V values) {
        int oldIndex;
        int hashKey = this.hashFunction.hash(key);

        if (hashKey < 0) {
            hashKey = -hashKey;
        }

        HashEntry newEntry = new HashEntry(key, value);

        if ((oldIndex = buckets.get(hashKey).indexOf(newEntry)) == -1) {
            buckets.get(hashKey).add(newEntry);
            itemCount++;
        } else {
            buckets.get(hashKey).set(oldIndex, newEntry);
        }
    }

    public V get (String key) {
        int i;
        LinkedList<HashEntry> temLL = buckets.get(this.hashFunction.hash(key));

        for (i = 0; i < temLL.size(); i++) {
            if (temLL.get(i).getKey() == key) {
                return temLL.get(i).getValue();
            }
        }

        return null;
    }

    public V remove (String key) {
        int i;
        V returnValue = null;

        LinkedList<HashEntry> tempLL = buckets.get(this.hashFunction.hash(key));
        for (i = 0; i < temLL.size(); i++) {
            if (tempLL.get(i).getKey() == key) {
                returnValue = tempLL.get(i).getValue();
                buckets.get(this.hashFunction.hash(key)).remove(i);
                itemCount--;
            }
        }
        return returnValue;
    }

    public int countCollisions(int numBuckets) {
        int collisions = 0;
        for (int i = 0; i < numBuckets; i ++) {
            if (buckets.get(i).size() > 1) {
                collisions += buckets.get(i).size() - 1;
            }
        }
        return collisions;
    }

    public int findDepthOfBucket(int bucketNumber) {
        return buckets.get(bucketNumber).size();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buckets.size(); i++) {
            sb.append("Bucket ");
            sb.append(i);
            sb.append(" has ");
            sb.append(buckets.get(i).size());
            sb.append(" items.\n");
        }

        sb.append("There are ");
        sb.append(itemCount);
        sb.append(" items in the hash table altogether.");
    }

}
