package algorithm.code.api.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by djt on 9/25/16.
 */
public class Trie {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "acdji";
		String str3 = "bcdji";
		TrieTree<String,Integer> tree = new TrieTree<>((a,b)->{
			return a+b;
		});
		tree.add(Arrays.asList(str1.split("")),1);
		tree.add(Arrays.asList(str2.split("")),1);
		tree.add(Arrays.asList(str3.split("")),1);
		tree.add(Arrays.asList(str3.split("")),1);
		tree.add(Arrays.asList(str3.split("")),1);
		System.out.println(tree.find(Arrays.asList(str3.split(""))));
	}
}
