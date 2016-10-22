package algorithm.code.codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class SqInRect {

	public static List<Integer> sqInRect(int lng, int wdth) {
		if (lng == wdth) {
			return null;
		}
		return dfs(Math.min(lng, wdth), Math.max(lng, wdth));
	}

	public static List<Integer> dfs(int lng, int wdth) {
		List<Integer> list = new ArrayList<>();
		if (lng == wdth) {
			list.add(lng);
		} else {
			list.add(lng);
			list.addAll(dfs(Math.min(lng, wdth - lng), Math.max(lng, wdth - lng)));
		}
		return list;
	}


	@Test
	public void test1() {
		List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
		for (int r : res)
			assertEquals(res, SqInRect.sqInRect(5, 3));
	}
	@Test
	public void test2() {
		assertEquals(null, SqInRect.sqInRect(5, 5));
	}
}
