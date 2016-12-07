package awesome;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by djt on 10/22/16.
 * java基础
 * <p>
 * 静态变量 初始化时间
 * try... catch...finally执行顺序
 *
 * Integer与int 的比较
 *
 * java多态执行
 */
public class Java {


	/**
	 * finally在return之前 ，先缓存return的结果，然后执行finally,然后return，若finally中有return，则覆盖缓存的return
	 *
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public static int aMethod(int i) throws Exception {
		try {
			return 10 / i;
		} catch (Exception ex) {
			throw new Exception("exception in a Method");
		} finally {
			System.out.printf("finally");
		}
	}

	@Test
	public void TestFinally() {
		try {
			aMethod(0);
		} catch (Exception ex) {
			System.out.printf("exception in main");
		}
		System.out.printf("finished");
	}

	public static void main(String[] args) {
		Set<Node> set = new HashSet<>();
		set.add(new Node("aaa",10));
		set.add(new Node("bbb",20));
		set.remove(new Node("mmm",10));
		set.add(new Node("ccc",10));
		System.out.println(Byte.valueOf("+1"));
	}
}
class Node{
	String val;
	int num;

	public Node(String val, int num) {
		this.val = val;
		this.num = num;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Node node = (Node) o;

		return num == node.num;

	}

	@Override
	public int hashCode() {
		return num;
	}
}