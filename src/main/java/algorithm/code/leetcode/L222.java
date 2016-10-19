package algorithm.code.leetcode;

/**
 * 边界条件不好判断时可以考虑 使用递归写法
 */
public class L222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode temp = root;
        int sum = 0;

        while (temp != null) {
            int height = getHeight(temp.left);
            if (height == getHeight(temp.right)) {
                sum += (1 << height);
                temp = temp.right;
            } else {
                sum += (1 << height - 1);
                temp = temp.left;
            }
        }
        return sum;
    }

    private int getHeight(TreeNode temp) {
        if (temp == null) return 0;
        int height = 1;
        while (temp.left != null) {
            temp = temp.left;
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        L222 l = new L222();
        TreeNode root = l.new TreeNode(10);
        root.left = l.new TreeNode(20);
        root.right = l.new TreeNode(20);
//
        TreeNode h4 = l.new TreeNode(10);
        TreeNode h5 = l.new TreeNode(10);
        TreeNode h6 = l.new TreeNode(10);
        TreeNode h7 = l.new TreeNode(10);
        root.left.left = h4;
        root.left.right = h5;
        root.right.left = h6;
//        root.right.right = h7;
        System.out.println(l.countNodes(root));
    }
}