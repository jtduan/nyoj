//package algorithm.code.segmentTree;
//
///**
// * @author jtduan
// * @date 2016/10/25
// * 线段树 示例代码
// * 功能 判断数组中i,j之间的最大值，并动态更新
// * <p>
// * Todo:
// * 1 线段树 为完全二叉树，因此可以使用数组代替
// * 2 往往在使用线段树钱需要进行 离散化，可以使用数组进行离散化（就是Arrays.sort然后用下标代替实际值）
// *
// * 3 Node节点可以仅仅包含value，左右边界不存储（这样函数参数会较多，不便于编码）
// * 4 Node节点可以增加延迟标记位
// * 5 标准线段树都是从根节点向下“遍历”或者“递归”,若想从叶子节点向上循环更新，需要额外的parent数组存储每个index对应的叶子节点
// */
//public class SegmentTree {
//
//    private Node[] nodes;
//
//    public SegmentTree(int n) {
//        this.nodes = new Node[n * 4];
//    }
//
//    /**
//     * 初始化线段树
//     * 标记每个节点的左右边界
//     */
//    public void init(int l, int r, int k) {
//        nodes[k].l = l;
//        nodes[k].r = r;
//        nodes[k].val = 0;
//        if (l == r) return;
//        int m = (l + r) >> 1;
//        init(l, m, k << 1);
//        init(m + 1, r, (k << 1) + 1);
//        return;
//    }
//
//    /**
//     * 查询区间
//     *
//     * @param l
//     * @param r
//     * @return
//     */
//    public int query(int l, int r) {
//    }
//
//    /**
//     * 单点更新
//     *
//     * @param index
//     */
//    public void update(int val, int index) {
//        //如果找到了就c值+1返回。
//        if (nodes[index].l == nodes[index].r && val > nodes[index].val) {
//            nodes[index].val = val;
//            return;
//        }
//        int m = (nodes[index].l + nodes[index].r) >> 1;
//        if (val <= m) update(val, index << 1);
//        else update(val, (index << 1) + 1);
//        nodes[index].val = Math.max(nodes[index << 1].val, nodes[(index << 1) + 1].val);
//    }
//
//    /**
//     * 区间更新
//     *
//     * @param l
//     * @param r
//     */
//    public void update(int l, int r, int val) {
//
//    }
//
//    class Node {
//        int l;
//        int r;
//        int val;
//    }
//}
