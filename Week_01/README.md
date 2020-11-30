# 第一周学习笔记

# 数据结构和算法总览

职业训练：拆分知识点、刻意练习、寻求反馈（主动、被动）

五步刷题法：

一、 刷题第一遍
五分钟：读题+思考（基础薄弱可延长至10min）
直接看解法：attention! 多解法比较优劣（时间、空间复杂度）
看大牛、背诵、默写好的解法

二、第二遍
马上脱稿自己写----->leetcode提交
debug->修改 反复直到通过
多种解法比较、体会------>优化

三、第三遍
24h 以后、重新做题
看解法熟练度决定是否需要反复练习

四、第四遍
一周后、重新做题

五、第五遍
面试前一周进行恢复性训练

算法题最大误区：只做一遍！！！（做题次数＞时长）

# 训练环境设置、编码技巧和Code Style

- [Windows Microsoft New Terminal](http://github.com/microsoft/terminal)

- [VS Code Themes](http://vscodethemes.com/)

- [教你打造一款颜值逆天的 VS Code](http://toutiao.io/posts/7w5ixl/preview)

- [炫酷的 VS Code 毛玻璃效果](http://juejin.im/post/5ce1365151882525ff28ed47)

- [自顶向下的编程方式](http://markhneedham.com/blog/2008/09/15/clean-code-book-review/)

  示例：

  ![image-20201130133003518](https://gitee.com/dong618/blog/raw/master/img/202011/20201130133005.png)

- [自顶向下编程的 LeetCode 例题](http://leetcode-cn.com/problems/valid-palindrome/)

# 时间复杂度和空间复杂度

## 时间复杂度

Big O notation

O(1): Constant Complexity 常数复杂度
O(log n): Logarithmic Complexity 对数复杂度
O(n): Linear Complexity 线性时间复杂度
O(n^2): N square Complexity 平方
O(n^3): N cubic Complexity 立方
O(2^n): Exponential Growth 指数
O(n!): Factorial 阶乘
注意：只看最高复杂度的运算

## 主定律

![image-20201130133712225](https://gitee.com/dong618/blog/raw/master/img/202011/20201130133713.png)

## 思考题

二叉树遍历 - 前序、中序、后序：O(N)
图的遍历：O(N)
搜索算法：DFS、BFS - O(N)

备注：N为树的节点总数，遍历节点时每个节点会访问一次且仅访问一次。

二分查找：O(logN)

## 空间复杂度

数组的长度

递归的深度

# 数组、链表、跳表的基本实现和特性