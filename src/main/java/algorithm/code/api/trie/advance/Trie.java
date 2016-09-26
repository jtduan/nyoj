package algorithm.code.api.trie.advance;

/**
 * Created by djt on 9/25/16.
 */
public class Trie {

	public static void main(String[] args) {
		String str1 = "ade";
		String str2 = "abc";
		String str3 = "abcde";
		String str4 = "afcde";
		String str5 = "af";
		String str6 = "java";
		String str7 = "gcc";
		TrieTree<String,Integer> tree = new TrieTree<>((a, b)->{
			return a+b;
		});
		tree.add(str1.split(""),1);
		tree.add(str2.split(""),1);
		tree.add(str3.split(""),1);
		tree.add(str4.split(""),1);
		tree.add(str5.split(""),1);
		tree.add(str6.split(""),1);
		tree.add(str7.split(""),1);
		System.out.println(tree.find(str1.split("")));
		System.out.println(tree.find(str2.split("")));
		System.out.println(tree.find(str3.split("")));
		System.out.println(tree.find(str4.split("")));
		System.out.println(tree.find(str5.split("")));
		System.out.println(tree.find(str6.split("")));
		System.out.println(tree.find(str7.split("")));
		System.out.println(tree.find("afc".split("")));

		tree.remove(str5.split(""));
		tree.remove(str3.split(""));
		tree.remove(str1.split(""));
		tree.remove(str2.split(""));
		System.out.println(tree.find(str4.split("")));
		System.out.println(tree.find(str5.split("")));
	}
}
