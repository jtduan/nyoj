package algorithm.code.utils.unionfindsets;

/**
 * 并查集模板代码
 */
public class UnionFindSet {

    private int[] set;
    private int[] size;
    private int count;

    public UnionFindSet(int n) {
        count = n;
        set = new int[n];
        size = new int[n];
        for (int i = 0; i < n; ++i) {
            set[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int x = find(p);
        int y = find(q);
        if (x == y) {
            return;
        }
        if (size[x] < size[y]) {
            set[x] = y;
            size[y] += size[x];
        } else {
            set[y] = x;
            size[x] += size[y];
        }
        count--;
    }

    public int find(int p) {
        while (p != set[p]) {
            // 将p节点的父节点设置为它的爷爷节点
            set[p] = set[set[p]];
            p = set[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) throws java.lang.Exception {
        UnionFindSet ufs = new UnionFindSet(10);
        ufs.union(1, 2);
        ufs.union(3, 4);
        ufs.union(5, 6);
        ufs.union(3, 6);
        ufs.union(7, 9);
        System.out.println(ufs.count());
        System.out.println(ufs.find(6));
        System.out.println(ufs.connected(4, 5));
        System.out.println(ufs.connected(8, 9));
    }
}
