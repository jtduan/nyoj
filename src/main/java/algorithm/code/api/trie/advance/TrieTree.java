package algorithm.code.api.trie.advance;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by djt on 9/25/16.
 */

public class TrieTree<K extends Comparable, V> {

	private TrieNode root;

	private BiFunction<V, V, V> biFunction;

	public TrieTree(BiFunction<V, V, V> biFunction) {
		this.root = new TrieNode(null);
		this.biFunction = biFunction;
	}

	public boolean add(K[] ks, V v) {
		TrieNode cur = root;
		int i = 0;
		while (i < ks.length) {
			TrieNode temp = cur.update(ks, i);
//			if (temp == null) {
//				TrieNode node = new TrieNode(Arrays.copyOfRange(ks, i, ks.length));
//				cur.addChild(node);
//				cur = node;
//				break;
//			}
//			else {
				cur = temp;
				i += temp.val.length;
//			}
		}
		cur.merge(cur.priority, v, biFunction);
		return true;
	}

	public V find(K[] ks) {
		TrieNode cur = root;
		int i = 0;
		while (i < ks.length) {
			TrieNode temp = cur.get(ks, i);
			if (temp == null) {
				return (V)null;
			} else {
				cur = temp;
				i += temp.val.length;
			}
		}
		return (V)cur.priority;
	}

	class TrieNode<K extends Comparable, V> {
		/**
		 * 节点的值
		 */
		K[] val;

		/**
		 * 节点权重
		 */
		V priority;

		ArrayList<TrieNode> next;

		public TrieNode(K[] ks) {
			this.val = ks;
			this.next = new ArrayList<>();
		}

		public TrieNode get(K[] ks, int start) {
			Iterator<TrieNode> it = next.iterator();
			while (it.hasNext()) {
				TrieNode node = it.next();
				int i = 0;
				while (start < ks.length && i< node.val.length && node.val[i].equals(ks[start])) {
					i++;
					start++;
				}
				if (i > 0 && i < node.val.length) {
					return null;
				}
				if (i != 0) {
					return node;
				}
			}
			return null;
		}
		public void merge(V priority, V v, BiFunction<V, V, V> biFunction) {
			if (priority == null) {
				this.priority = v;
			} else {
				this.priority = biFunction.apply(priority, v);
			}
		}

		private void divide(TrieNode node,int index) {
			int length = node.val.length;
			TrieNode temp = new TrieNode(Arrays.copyOfRange(node.val, index, length));
			temp.priority = node.priority;
			node.priority = null;
			node.next.add(temp);
			node.val = Arrays.copyOf(node.val, index);
		}

		public TrieNode update(K[] ks, int start) {
			int index = findChild(ks[start]);
			if(index < 0){
				TrieNode node = new TrieNode(Arrays.copyOfRange(ks, start, ks.length));
				addChild(node,-index-1);
				return node;
			}
			int i = 1;
			start++;
			TrieNode node = next.get(index);
			while (start < ks.length && i< node.val.length && node.val[i].equals(ks[start])) {
				i++;
				start++;
			}
			if (i > 0 && i < node.val.length) {
				divide(node,i);
			}
			return node;
		}

		public void addChild(TrieNode child,int index) {
			next.add(index,child);
		}

		public int findChild(K k) {
			int index = Collections.binarySearch(next, k,(a,b)->{
				return ((TrieNode)a).val[0].compareTo(b);
			});
			return index;
		}
	}
}