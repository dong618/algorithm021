//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1421 👎 0


package leetcode.editor.cn;

import java.util.List;

//Java：合并两个有序链表
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST 1->2->4, 1->3->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        print(l1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        print(l2);

        print(solution.mergeTwoLists(l1,l2));

    }


    //打印输出方法
    static void print(ListNode listNode){
        //创建链表节点
        while(listNode!=null){
            System.out.println("节点:"+listNode.val);
            listNode=listNode.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 思路2 引入哨兵节点 head
     * l1 < l2  head->l1  l1 = l1.next; 继续比较
     * l1 >= l2 head->l2  l2 = l2.next; 继续比较
     * head = head.next
     * 合并后 l1 和 l2 最多只有一个还未被合并完，直接将链表末尾指向未合并完的链表即可
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return head.next;

    }

    /**
     * 思路1 采用递归
     * 如果l1.val < l2.val
     * 则l1.next= f(l1.next,l2)  返回了
     *
     * 如果l1.val >= l2.val
     * 则l2.next = f(l1,l2.next)
     *
     * 时间复杂度：O(n + m)O(n+m)，其中 n 和 m 分别为两个链表的长度
     * 空间复杂度：O(n + m)O(n+m)，其中 n 和 m 分别为两个链表的长度
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return  l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}