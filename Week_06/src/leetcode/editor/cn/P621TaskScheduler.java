package leetcode.editor.cn;

//Java：任务调度器
public class P621TaskScheduler {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] list = new int[26];
        for (char c : tasks) {
            list[c - 'A']++;
        }
        Arrays.sort(list);
        int bz = list[25];
        int cnt = 0;
        for (int i = 25; i >= 0; i--) {
            if (list[i] != bz) break;
            cnt++;
        }
        return Math.max(len, cnt + (n + 1) * (bz - 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
