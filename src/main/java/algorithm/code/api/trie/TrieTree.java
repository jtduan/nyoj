package algorithm.code.api.trie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by djt on 9/25/16.
 * Todo:提供二分Comparable API
 */

public class TrieTree<K, V> {

	private TrieNode root;

	private BiFunction<V,V,V> biFunction;

	public TrieTree(BiFunction<V,V,V> biFunction) {
		this.root = new TrieNode();
		this.biFunction=biFunction;
	}

	public boolean add(List<K> list, V v) {
		TrieNode cur = root;
		Iterator<K> it = list.iterator();
		while (it.hasNext()) {
			K k = it.next();
			TrieNode temp = cur.get(k);
			if(temp ==null){
				TrieNode node = new TrieNode(k);
				cur.next.add(node);
				cur=node;
			}
			else{
				cur = temp;
			}
		}
		cur.merge(cur.priority,v,biFunction);
		return false;
	}

	public Object find(List<K> list){
		TrieNode cur = root;
		Iterator<K> it = list.iterator();
		while (it.hasNext()) {
			K k = it.next();
			TrieNode temp = cur.get(k);
			if(temp ==null){
				return null;
			}
			else{
				cur = temp;
			}
		}
		return cur.priority;
	}

	class TrieNode<K,V>{
		/**
		 * 节点的值
		 */
		K val;

		/**
		 * 节点权重
		 */
		V priority;

		List<TrieNode> next;

		public TrieNode(K k) {
			this.val = k;
			this.next = new ArrayList<>();
		}

		public TrieNode() {
			this.next = new ArrayList<>();
		}

		public TrieNode get(K k) {
			Iterator<TrieNode> it = next.iterator();
			while (it.hasNext()) {
				TrieNode node = it.next();
				if (node.val.equals(k)) {
					return node;
				}
			}
			return null;
		}

		public void merge(V priority, V v,BiFunction<V,V,V> biFunction) {
			if(priority == null){
				this.priority=v;
			}
			else{
				this.priority=biFunction.apply(priority,v);
			}
		}
	}
}