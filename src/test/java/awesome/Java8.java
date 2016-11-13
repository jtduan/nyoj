import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by djt on 11/12/16.
 */
public class Java8 {

	private static List<MyObj> list;

	private static MyObj[] arrs;

	@Before
	public void init() {
		list = new ArrayList<>();
		list.add(new MyObj(1, "1"));
		list.add(new MyObj(2, "2"));
		list.add(new MyObj(3, "3"));
		list.add(new MyObj(4, "4"));
		arrs = new MyObj[4];
		for (int i = 0; i < arrs.length; i++) {
			arrs[i] = new MyObj(i, "" + i);
		}
	}

	/**
	 * 总结：
	 * reduce函数 为合并,输入与输出的数据类型需要一致
	 */
	@Test
	public void testCollectors() {
		Assert.assertEquals(10,list.stream().collect(Collectors.summarizingInt((s)->s.getVal())).getSum());
		System.out.println(list.stream().map((s)->s.getStr()).collect(Collectors.joining()));
		list.stream().mapToInt((s)->s.getVal()).reduce(Integer::sum);
		list.stream().max((a,b)->a.getVal()-b.getVal());
//		list.stream().reduce(((a,b)->a.getVal()+b.getVal())); //错误，输入输出不一致
		list.stream().collect(Collectors.reducing(0,(s)->s.getVal(),Integer::sum));

		System.out.println(list.stream().reduce((a,b)-> new MyObj(a.val+b.getVal(),a.getStr()+b.getStr())).get()
				.getStr());
	}

}

class MyObj {
	int val;
	String str;

	public MyObj(int val, String str) {
		this.val = val;
		this.str = str;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}