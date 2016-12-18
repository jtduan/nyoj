package awesome;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by djt on 10/24/16.
 */
public class Note2 {
	/**
	 * 正则表达式 多行模式与单行模式
	 * ?s 为.可以匹配换行符
	 * ?m 为多行模式,仅仅影响^和$
	 * 区别，在?m下 .不可以匹配换行符
	 * (?s比?m范围广)
	 */

	 @Test
	public void test(){
		 String str="asd\nzxc\nqwe";
		 System.out.println(str.matches("(?s)a.*e$"));
	 }

	/**
	 * Collections.CheckedList 功能
	 * 保证List中新增加的数据数据类型是符合参数定义的
	 * 正确的使用方式是new一个新的CheckedList并调用addAll()
	 */
	@Test(expected = ClassCastException.class)
	public void testCheckList() {
		ArrayList list = new ArrayList();
		list.add(5);
		list.add(8);
		list.add(1, 6);
		List s = Collections.checkedList(list, String.class);
		s.add('s'); /** 会发生异常，无法插入指定类型外的数据**/
		System.out.println(s.size());
	}
}
