package leetcode.editor.cn;
//Java：岛屿数量
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * @author dongxujiao
     * @description 先考虑并查集方法
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则将其与相邻四个方向上的 1 在并查集中进行合并。
     *
     * 最终岛屿的数量就是并查集中连通分量的数目。
     *
     * @date 2021-01-13 14:36
     * @return
     */
    class Solution {
        private int rows,cols,numIslands = 0;
        private int[] parent;
        public int numIslands(char[][] grid) {
            rows = grid.length;
            cols = grid[0].length;
            if (rows == 0) {
                return 0;
            }

            parent = new int[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    parent[i * cols + j] = i * cols + j;
                }
            }


            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    //如果是陆地
                    if (grid[r][c] == '1') {
                        numIslands ++;
                        //逐步合并
                        if (c + 1 < cols && grid[r][c+1] == '1') {
                            union(getIndex(r,c),getIndex(r,c+1));
                        }

                        if (r + 1 < rows && grid[r+1][c] == '1') {
                            union(getIndex(r,c),getIndex(r+1,c));
                        }
                    }
                    grid[r][c] = '0';
                }
            }
            return numIslands;
        }

        private int getIndex(int r, int c) {
            return r * cols + c;
        }


        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            parent[rootP] = rootQ;
            numIslands--;
        }

    }

    //leetcode submit region end(Prohibit modification and deletion)

}
