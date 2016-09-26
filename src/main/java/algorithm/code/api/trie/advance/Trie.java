package algorithm.code.api.trie.advance;

import java.util.Arrays;

/**
 * Created by djt on 9/25/16.
 */
public class Trie {

	public static void main(String[] args) {
		String str1 = "ade";
		String str2 = "abc";
		String str3 = "abcde";
		String str4 = "afc";
		TrieTree<String,Integer> tree = new TrieTree<>((a, b)->{
			return a+b;
		});
		tree.add(str1.split(""),1);
		tree.add(str2.split(""),1);
		tree.add(str3.split(""),1);
		tree.add(str4.split(""),1);
		tree.add(str3.split(""),1);
		tree.add(str3.split(""),1);
		System.out.println(tree.find(str2.split("")));
		System.out.println(tree.find(str3.split("")));
		System.out.println(tree.find(str1.split("")));
		System.out.println(tree.find("abcf".split("")));
	}
}
