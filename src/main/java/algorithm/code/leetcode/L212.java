package algorithm.code.leetcode;

import java.util.*;

/**
 * 前缀树的应用(Tire)
 * Todo:
 * 1 在原图上修改实现vidited功能，节省空间
 * 2 Tire树next节点使用Hash数组的形式，提高速度
 * 3 没有必要在非dictionary节点存储不相关的值
 *
 */
public class L212 {
    Set<String> res = new TreeSet<>();
    private int[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        visited = new int[board.length][board[0].length];
        Node root = buildTire(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }
        return new ArrayList<>(res);
    }

    public Node buildTire(String[] words) {
        Node root = new Node('R');
        for (String word : words) {
            update(root, word);
        }
        return root;
    }

    public void update(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (root.get(word.charAt(i)) == null) {
                Node n = new Node(word.charAt(i));
                root.set[word.charAt(i) - 'a'] = n;
                root = n;
            } else {
                root = root.get(word.charAt(i));
            }
        }
        root.val++;
        root.strs=word;
    }

    private void dfs(char[][] board, int i, int j, Node root) {
        if (root.val > 0) res.add(root.strs);
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j] == 1) return;
        if (root.get(board[i][j]) == null) return;

        visited[i][j] = 1;
        dfs(board, i + 1, j, root.get(board[i][j]));
        dfs(board, i, j + 1, root.get(board[i][j]));
        dfs(board, i - 1, j, root.get(board[i][j]));
        dfs(board, i, j - 1, root.get(board[i][j]));
        visited[i][j] = 0;
    }

    class Node {
        public char ch;
        public int val;
        public String strs;
        Node[] set;

        public Node(char ch) {
            this.ch = ch;
            set = new Node[26];
            strs = "";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return ch == node.ch;

        }

        @Override
        public int hashCode() {
            return (int) ch;
        }

        public Node get(char ch) {
            if (set[ch - 'a'] != null) return set[ch - 'a'];
            return null;
        }
    }

    public static void main(String[] args) {
        Node root = new L212().buildTire(new String[]{"s"});
    }
}
