import org.apache.commons.collections.iterators.ArrayListIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by djt on 10/22/16.
 */
public class Note {

	/**
	 * 数组转string 使用String.valueOf()
	 * 不要使用toString()
	 */
	@Test
	public void TestConvertString(){
		char[] chars = new char[]{'d','o'};
		System.out.println(chars.toString());
		System.out.println(String.valueOf(chars));
	}

	/**
	 * List复制，使用addAll 或者 构造函数
	 * 不要使用 Collections.copy(dst,src)
	 */

	public void newList(){
		List<Integer> src = new ArrayList<>();
		src.add(10);
		src.add(19);
		List<Integer> dst = new ArrayList<>(src);
//		dst.addAll(src);
//		Collections.copy(dst,src);
	}

	/**
	 * 数组复制，使用Arrays.copyOfRange()
	 */

	/**
	 * 注意动态规划边界条件和起始条件（Leetcode139）
	 */

	/**
	 * 注意DFS退出条件
	 */
}
