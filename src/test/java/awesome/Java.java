import org.junit.Test;

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
}
