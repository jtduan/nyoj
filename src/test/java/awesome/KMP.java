import org.junit.Assert;
import org.junit.Test;

/**
 * Created by djt on 10/22/16.
 * KMP算法：
 * 本示例使用的原则：
 * 1 next[0]=-1
 * 2 next[i]为字符串0-i(含i）前缀与后缀相同的长度
 *
 * 当第i位不相等时，字符串可以向后移动i-next[i]位（所以next[0]需要为-1防止死循环）
 */
public class KMP {

	/**
	 * 直观算法，每次
	 * @param src
	 * @param dst
	 * @return
	 */
	public int find(char[] src, char[] dst) {
		int[] next = getNext(dst);
		int start = 0;
		int end = start;
		while (end < src.length) {
			int i = start;
			while (src[i] == dst[end - start]) {
				end++;
				i++;
				if (end - start == dst.length) return start;
			}
			start = end - next[end - start];
			end = start;
		}
		return -1;
	}


	/**
	 * 在暴力搜索的基础上修改，不匹配时不再仅仅后移一步
	 * @param src
	 * @param dst
	 * @return
	 */
	public int find2(char[] src, char[] dst) {
		int[] next = getNext(dst);
		int i = 0;
		int j = 0;
		while (i < src.length && j < dst.length) {
			if (src[i] == dst[j]) {
				i++;
				j++;
			} else {
				i = i - next[j];
				j = 0;
			}
		}
		if (j == dst.length) return i - dst.length;
		return -1;
	}

	/**
	 *
	 * @param dst
	 * @return
	 */
	private int[] getNext(char[] dst) {
		int[] next = new int[dst.length];
		next[0] = -1;
		for (int i = 1; i < next.length; i++) {
			int j = next[i - 1];
			while (j > 0 && dst[j] != dst[i]) {
				j = next[j];
			}
			if (j == -1 || dst[i] == dst[j]) next[i] = j + 1;
			else next[i] = 0;
		}
		return next;
	}


	@Test
	public void TestKMP() {
		String src = "twmzxhhmzdjsu";
		String dst = "mzxhhmzd";
		Assert.assertEquals(2, find(src.toCharArray(), dst.toCharArray()));
	}
}
