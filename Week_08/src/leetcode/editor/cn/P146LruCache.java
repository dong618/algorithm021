package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

//Java：LRU 缓存机制
public class P146LruCache{
    public static void main(String[] args) {
        Solution solution = new P146LruCache().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        /**
         * //调用父类HashMap的构造方法。
         * Constructs an empty insertion-ordered <tt>LinkedHashMap</tt> instance
         * with the default initial capacity (16) and load factor (0.75).
         */
        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
