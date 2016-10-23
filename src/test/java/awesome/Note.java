import org.apache.commons.collections.iterators.ArrayListIterator;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	/**
	 * double类型保留2位小数
	 */
	public void parseDouble(){
		NumberFormat ddf1= NumberFormat.getNumberInstance();
		ddf1.setMaximumFractionDigits(2);
		ddf1.setMinimumFractionDigits(2);
	}

	/**
	 * 判断char是否为字母，数字，应当使用Character类
	 */
	public void checkCharacter(){
		Character.isLetter('A');
		Character.isWhitespace(' ');
		Character.isDigit('0');
		Character.getNumericValue('9');
		Character.toLowerCase('A');
		Character.isLowerCase('a');
	}

	/**
	 * Collections转Array
	 * 使用toArray(new String[0])，不带参数时返回为Object
	 */
	public void CollectionsToArray(){
		Stack<String> s = new Stack<>();
		s.toArray(new String[0]);
	}

	/**
	 * -8%6 == -2
	 */

	/**
	 * Collections 内置一个route函数用于循环移位
	 * Arrays.asList 仅仅相当于将data变换为List形式，构造出一个私有内部类（不是java.util的ArrayList）,
	 * 不可以增删，但可以修改某一位，等同于修改data数组
	 */
	public Object[] rotate(Object[] data, int n) {
		Collections.rotate(Arrays.asList(data), n);
		return data;
	}

	/**
	 * String.join 将String数组合在一起
	 */


	/**
	 * 使用JAVA8流式编程
	 */
	public void streams(){
		/**
		 * string转chars流
		 */
		"shd".chars().map((c)->c-'a');

		/**
		 * 数组转换为流
		 */
		Arrays.stream(new int[]{2,3,4}).sum();
		/**
		 * List直接转换为流
		 */
		new ArrayList<>().stream().collect(Collectors.toList());
	}

	/**
	 * Integer.bitCount()可以统计1的个数
	 */

	/**
	 * Arrays.sort(num,start,end)可以对数组的一部分进行排序
	 */

}
