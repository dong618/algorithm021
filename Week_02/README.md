# 学习笔记02

# 哈希表、映射、集合

HashSet 集合的**数据结构**：

JDK1.8 之后是数组+红黑树；
哈希值不同的元素放在数组中不同的位置上；
哈希值相同的元素放在数组中某个位置的树上。

复杂度分析：

![image-20201210101350195](https://gitee.com/dong618/blog/raw/master/img/202011/20201210101351.png)

# 树、二叉树、二叉搜索树

Linked List 是特殊化的 Tree
Tree 是特殊化的 Graph

- 二叉树遍历：

前序：根-左-右

中序：左-根-右

后序：左-右-根

- 二叉搜索树，

也称二叉排序树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：

1. 左子树上所有结点的值均**小于**它的根结点的值；

2. 右子树上所有结点的值均**大于**它的根结点的值；

3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）

  中序遍历：升序排列

# 堆和二叉堆的实现和特性

堆：Heap 可以迅速找到一堆树中的最大或者最小的值的数据结构

二叉堆：通过完全二叉树来实现（注：不是二叉搜索树），满足以下特性：

- 是一个完全树

- 树中任意节点的值总是>=其子节点的值

1. 根节点(顶堆元素)是: a[0]

2. 索引为i的左孩子的索引是(2*i+1);

3. 索引为i的右孩子的索引是(2*i+2);

4. 索引为i的父结点的索引是floor((i-1)/2);

# 图

- 图的属性：Graph(V,E)

V - vertex：点

1.度：入度和出度

2.点与点之间联通与否

E - edge：边

1.有向和无向（单行线）

2.权重（边长）

- 图的表示和分类：

1. 无向无权图

   ![image-20201210113101672](https://gitee.com/dong618/blog/raw/master/img/202012/20201210113103.png)

2. 有向无权图

   ![image-20201210113048261](https://gitee.com/dong618/blog/raw/master/img/202012/20201210113049.png)

3. 无向有权图

   ![image-20201210113033957](https://gitee.com/dong618/blog/raw/master/img/202012/20201210113035.png)



# HashMap分析

## 底层数据结构

在JDK1.6，JDK1.7中，HashMap采用**位桶+链表**实现，即使用链表处理冲突,同一hash值的键值对会被放在同一个位桶里，当桶中元素较多时，通过key值查找的效率较低。

而JDK1.8中，HashMap采用**位桶+链表+红黑树**实现，当链表长度超过阈值（8）,时，将链表转换为红黑树，这样大大减少了查找时间。

## HashMap的实现原理：

*//Node是单向链表，它实现了Map.Entry接口*  

Node<K,V>[] tab

//红黑树

TreeNode<k,v>

1，判断键值对数组tab[]是否为空或为null，否则以默认大小resize()；
2，根据键值key计算hash值得到插入的数组索引i，如果tab[i]==null，直接新建节点添加，否则转入3
3，判断当前数组中处理hash冲突的方式为链表还是红黑树(check第一个节点类型即可),分别处理

```java
/**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * Implements Map.put and related methods.
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

参考文章：https://blog.csdn.net/hefenglian/article/details/79763634