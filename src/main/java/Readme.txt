# 知识点
## 树状数组 bitree
    - 实现方式:主要包含`init`,`update`和`query`方法
## 大根堆和小根堆 heap
    - 实现方式:主要包含`HeapUp`和`HeapDown`方法
    - java中可以使用现成的实现：优先队列(PriorityQueue）
## 红黑树 rbtree(待研究）
    - java中红黑树现成的实现：TreeMap
## 博弈论
    - 巴什博弈
        + `num % (limit + 1)` 结果大于0时，先出手的胜利，等于0时，后出手胜利
    - 威佐夫博弈
        +
    - 尼姆博弈
        + ans ^= pernum 结果大于0时，先出手的胜利，等于0时，后出手胜利

## 凸包问题
    - Graham Scan算法
    - GiftWrapping算法
## other
    - 使用队列进行BFS搜索时，入队时标记 效果好于 出队时标记（`nyoj92`）
    - 乘除2时可以使用移位代替
    - 可以使用静态数组模拟循环较少的情况（比如矩阵的BFS`nyoj92`,`nyoj52`）