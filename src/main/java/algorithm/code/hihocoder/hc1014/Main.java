package algorithm.code.hihocoder.hc1014;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 * @date 2016/11/3
 * Trie树
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/hc1014.txt"), "utf8");
        cin = new Scanner(System.in);
        int N = cin.nextInt();
        cin.nextLine();
        Node root = new Node('a');
        for (int i = 0; i < N; i++) {
            String str = cin.nextLine();
            addTrie(root, str);
        }
        int ask = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < ask; i++) {
            String str = cin.nextLine();
            System.out.println(find(root, str));
        }
    }

    private static int find(Node root, String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            root = root.childs[ch - 'a'];
            if (root == null) return 0;
        }
        return root.num;
    }

    private static void addTrie(Node root, String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (root.childs[ch - 'a'] == null) {
                root.childs[ch - 'a'] = new Node(ch);
            }
            root = root.childs[ch - 'a'];
            root.num++;
        }
    }
}

class Node {
    char val;
    int num;
    Node[] childs;

    public Node(char val) {
        this.val = val;
        this.num = 0;
        this.childs = new Node[26];
    }
}
