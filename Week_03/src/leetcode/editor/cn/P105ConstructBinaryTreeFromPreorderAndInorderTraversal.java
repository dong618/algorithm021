//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 791 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> map ;

    /**
     * @author dongxujiao
     * @description TODO
     * @date 2020-12-16 15:06
     * @param preorder 前序数组
     * @param inorder 中序数组
     * @param preorder_left  前序节点 左边界
     * @param preorder_right 前序节点 右边界
     * @param inorder_left 中序节点 左边界
     * @param inorder_right 中序节点 右边界
     * @return leetcode.editor.cn.TreeNode
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if ( preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int pre_root = preorder_left;
        // 在中序遍历中定位根节点 preorder[pre_root] 根节点的值
        int in_root = map.get(preorder[pre_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[pre_root]);
        // 得到左子树中的节点数目
        int left_sub_size = in_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder,inorder,preorder_left + 1,preorder_left + left_sub_size,inorder_left,in_root-1 );
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder,inorder,preorder_left + 1 +left_sub_size,preorder_right,in_root + 1,inorder_right);
        return root;
    }
    /**
     * @author dongxujiao
     * @description
     * 对于任意一颗树而言，前序遍历的形式总是
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     *
     * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     *

     * @date 2020-12-16 14:52
     * @param preorder
     * @param inorder
     * @return leetcode.editor.cn.TreeNode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        map = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder,inorder,0,len-1,0,len-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}