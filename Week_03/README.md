# 学习笔记03

# 泛型递归、树的递归

递归方法的一般步骤

```java
public void recur(int level, int param) {
// terminator 1 递归终止条件
if (level > MAX_LEVEL) {
// process result
return;
}
// process current logic 2 处理当前层逻辑
process(level, param);
// drill down  3 到下一层
recur( level: level + 1, newParam);
// restore current status 4 清理当前层
}
```

思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

# 分治、回溯

最关键的问题是找重复性，分治和回溯可以理解为复杂的递归。

- 分治（将一个问题划分为子问题进行解决）

![image-20201216140008343](https://gitee.com/dong618/blog/raw/master/img/202012/20201216140010.png)

分治代码模板

参考地址：https://shimo.im/docs/zvlDqLLMFvcAF79A/read

```java
private static int divide_conquer(Problem problem, ) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  result = process_result(res0, res1);
  
  return result;
}
```

- 回溯

回溯法采用试错的思想，它尝试分步的去解决一个问题。在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
• 找到一个可能存在的正确的答案；
• 在尝试了所有可能的分步方法后宣告该问题没有答案。
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算



