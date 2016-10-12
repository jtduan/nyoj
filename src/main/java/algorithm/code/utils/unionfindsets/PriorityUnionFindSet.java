package algorithm.code.utils.unionfindsets;

/**
 * NYOJ207
 * <p>
 * <p>
 * 0: 同类
 * 2：子吃父
 * 1: 父吃子
 */
public class PriorityUnionFindSet {

    private int[] set; //联通关系
    private int[] size; //树的大小
    private int[] priority; //父子关系（权值）

    private int count; //树的个数

    public PriorityUnionFindSet(int n) {
        count = n;
        set = new int[n];
        size = new int[n];
        priority = new int[n];
        for (int i = 0; i < n; ++i) {
            set[i] = i;
            size[i] = 1;
            priority[i] = 1;
        }
    }

    public void union(int p, int q, int _priority) {
        int x = find(p);
        int y = find(q);
        if (x == y) {
            return;
        }
        if (size[x] < size[y]) {
            set[x] = y;
            priority[x] = (_priority + priority[q] - priority[p] + 3) % 3;
            size[y] += size[x];
        } else {
            set[y] = x;
            priority[y] = (-_priority - priority[q] + priority[p] + 3) % 3;
            size[x] += size[y];
        }
        count--;
    }


    public int find(int p) {
        if (p == set[p]) {
            return p;
        }
        int root = find(set[p]);
        priority[p] = (priority[p] + priority[set[p]]) % 3;
        set[p] = root;
        return root;
    }

    public int relation(int p, int q) {
        if (find(p) != find(q)) {
            throw new RuntimeException("无法判断关系");
        }
        return (priority[p] - priority[q] + 3) % 3;
    }
}
