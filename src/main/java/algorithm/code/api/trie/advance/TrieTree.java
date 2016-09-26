package algorithm.code.api.trie.advance;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by djt on 9/25/16.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class TrieTree<K extends Comparable, V> {

    private TrieNode root;

    private BiFunction<V, V, V> biFunction;

    /**
     * Instantiates a new Trie tree.
     *
     * @param biFunction the bi function
     */
    public TrieTree(BiFunction<V, V, V> biFunction) {
        this.root = new TrieNode(null);
        this.biFunction = biFunction;
    }

    public boolean add(List<K> ks, V v) {
        return add((K[]) ks.toArray(), v);
    }

    /**
     * 从根节点出发，依次寻找下一层节点,寻找下一层节点时自动触发分裂动作，找不到时触发添加节点动作
     *
     * @param ks the key of the new Trie
     * @param v  the priority of the ks
     * @return the boolean
     */
    public boolean add(K[] ks, V v) {
        TrieNode cur = root;
        int i = 0;
        while (i < ks.length) {
            TrieNode temp = cur.update(ks, i);
            cur = temp;
            i += temp.val.length;
        }
        cur.merge(cur.priority, v, biFunction);
        return true;
    }

    public V find(List<K> ks) {
        return find((K[]) ks.toArray());
    }

    /**
     * Find the priority of the Trie Key
     * 从根节点出发，依次寻找下一层节点,找不到返回空
     *
     * @param ks the Trie Key
     * @return the priority
     */
    public V find(K[] ks) {
        TrieNode cur = root;
        int i = 0;
        while (i < ks.length) {
            TrieNode temp = cur.get(ks, i);
            if (temp == null) {
                return (V) null;
            } else {
                cur = temp;
                i += temp.val.length;
            }
        }
        return (V) cur.priority;
    }


    /**
     * 删除一个节点，无论该节点权值大小
     * 如果需要降低权值，请使用add()方法，并且传入合适的BiFunction
     *
     * @param ks
     * @return
     */
    public boolean remove(K[] ks) {
        TrieNode cur = root;
        TrieNode pre = root;
        TrieNode waitRemove = null;
        int i = 0;
        while (i < ks.length) {
            TrieNode temp = cur.get(ks, i);
            if (temp == null) {
                return false;
            } else if (cur.next.size() > 1 || cur.priority!=null) {
                pre = cur;
                waitRemove = temp;
            }
            cur = temp;
            i += temp.val.length;
        }
        if(pre == root && waitRemove==null){
            if(pre.next.size()==1){
                pre.next.clear();
                return true;
            }
            return false;
        }
        else{
            pre.next.remove(waitRemove);
            return true;
        }
    }

    public boolean remove(List<K> ks) {
        return remove((K[]) ks.toArray());
    }
    /**
     * The type Trie node.
     *
     * @param <K> the type parameter
     * @param <V> the type parameter
     */
    class TrieNode<K extends Comparable, V> {
        /**
         * 节点的值
         */
        K[] val;

        /**
         * 节点权重
         */
        V priority;

        /**
         * The Next.
         */
        ArrayList<TrieNode> next;

        /**
         * Instantiates a new Trie node.
         *
         * @param ks the ks
         */
        public TrieNode(K[] ks) {
            this.val = ks;
            this.next = new ArrayList<>();
        }

        /**
         * Get trie node.
         *
         * @param ks    the ks
         * @param start the start
         * @return the trie node
         */
        public TrieNode get(K[] ks, int start) {
            int index = findChild(ks[start]);
            if (index < 0) {
                return null;
            }
            int i = 1;
            start++;
            TrieNode node = next.get(index);
            while (start < ks.length && i < node.val.length && node.val[i].equals(ks[start])) {
                i++;
                start++;
            }
            if (i > 0 && i < node.val.length) {
                return null;
            }
            return node;
        }

        /**
         * Merge.
         *
         * @param priority   the priority
         * @param v          the v
         * @param biFunction the bi function
         */
        public void merge(V priority, V v, BiFunction<V, V, V> biFunction) {
            if (priority == null) {
                this.priority = v;
            } else {
                this.priority = biFunction.apply(priority, v);
            }
        }

        private void divide(int index) {
            int length = this.val.length;
            TrieNode temp = new TrieNode(Arrays.copyOfRange(this.val, index, length));
            temp.next = this.next;
            temp.priority = this.priority;
            this.priority = null;
            this.next=new ArrayList<>();
            this.next.add(temp);
            this.val = Arrays.copyOf(this.val, index);
        }

        /**
         * Update trie node.
         *
         * @param ks    the ks
         * @param start the start
         * @return the trie node
         */
        public TrieNode update(K[] ks, int start) {
            int index = findChild(ks[start]);
            if (index < 0) {
                TrieNode node = new TrieNode(Arrays.copyOfRange(ks, start, ks.length));
                addChild(node, -index - 1);
                return node;
            }
            int i = 1;
            start++;
            TrieNode node = next.get(index);
            while (start < ks.length && i < node.val.length && node.val[i].equals(ks[start])) {
                i++;
                start++;
            }
            if (i > 0 && i < node.val.length) {
                node.divide(i);
            }
            return node;
        }

        /**
         * Add child.
         *
         * @param child the child
         * @param index the index
         */
        public void addChild(TrieNode child, int index) {
            next.add(index, child);
        }

        /**
         * Find child int.
         *
         * @param k the k
         * @return the int
         */
        public int findChild(K k) {
            int index = Collections.binarySearch(next, k, (a, b) -> {
                return ((TrieNode) a).val[0].compareTo(b);
            });
            return index;
        }
    }
}