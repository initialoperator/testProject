
/**
 * 
 Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

easy mistakes:
Forget count++ and count-- everytime when there is change in the List indices (in method put())
*To make it completely O(1), you need to (likely to create your own) double-linkedlist, from which you can access the each node. (Yet to be done in this program)
 * 
 */
public class LRUCacheTest{

    public static void main(String[] args) {
        LRUCache c = new LRUCache();

    }


    static class LRUCache {

        int cap = 0;
        Map<Integer, Integer> map;
        LinkedList<Integer> indices;
        int count = 0;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            indices = new LinkedList<>();
        }
        
        public int get(int key) {
            if(map.containsKey(key)){
                int value = map.get(key);
                Integer recent = indices.remove(indices.indexOf(key));
                System.out.println("value to be most recent: " + recent);
                indices.addLast(recent);
                return value;
            }else
                return -1;
        }
        
        public void put(int key, int value) {
            if(map.containsKey(key)){
                indices.remove(new Integer(key));
                count--;
            }
            map.put(key, value);
            indices.addLast(key);
            count++;
            
            if(count > cap){
                Integer least = indices.removeFirst();
                map.remove(least);
                count--;
            }
        } 
        }    
        
        
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

}