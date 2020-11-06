import java.util.ArrayList;

public class MyHashTable<K, V> {

    private static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private ArrayList<HashNode<K, V>> arr;
    private int size;
    private int capacity;
    final double DEFAULT_LOAD_FACTOR = 0.75;

    public MyHashTable() {
        capacity = 11;
        arr = new ArrayList<HashNode<K, V>>();
        size = 0;
        for (int i = 0; i < capacity; i++) {
            arr.add(null);
        }
    }

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        arr = new ArrayList<HashNode<K, V>>();
        size = 0;
        for (int i = 0; i < this.capacity; i++) {
            arr.add(null);
        }
    }

    public boolean contains(K key) {
        int index = getIndex(key);
        HashNode<K, V> head = arr.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return true;
            }
            head = head.next;
        }

        return false;

    }

    public V remove(K key) {
        int index = getIndex(key);
        System.out.println(index);
        HashNode<K, V> head = arr.get(index);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            } else {
                prev = head;
                head = head.next;
            }
        }
        if (head == null) {
            return null;
        }
        if (prev != null) {
            prev.next = head.next;
        } else {
            arr.set(index, head.next);
        }
        size--;
        return head.value;
    }

    public V add(K key, V value) {
        int index = getIndex(key);
        HashNode<K, V> head = arr.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                V oldValue = head.value;
                head.value = value;
                return oldValue;
            }
            head = head.next;
        }

        size++;
        head = arr.get(index);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        arr.set(index, newNode);

        double loadFactor = (1.0 * size) / capacity;
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            rehash();
        }
        return null;
    }

    protected void rehash() {
        ArrayList<HashNode<K, V>> list = arr;
        arr = new ArrayList<>(2 * capacity);

        for (int i = 0; i < 2 * capacity; i++) {
            arr.add(null);
        }
        size = 0;
        capacity *= 2;

        for (HashNode<K, V> head : list) {
            while (head != null) {
                K key = head.key;
                V value = head.value;
                add(key, value);
                head = head.next;
            }
        }

    }

    private int getIndex(K key) {
        int hash = key.hashCode();
        return Math.abs(hash % arr.size());
    }

    public int size() {
        return size;
    }

    public V get(K key) {

        if (this.contains(key)) {
            int index = getIndex(key);
            HashNode<K, V> head = arr.get(index);

            while (head != null) {
                if (head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }

        }
        return null;
    }

    /*public static void main(String[] args){
        MyHashTable<Integer, Integer> table = new MyHashTable<>();
        table.add(1, 10);
        table.add(2, 20);
        table.remove(-10);
    }*/
}
