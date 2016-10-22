package algorithm.code.codewars;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */

public class Groups {

	public static boolean groupCheck(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && isPattern(stack.peek(), s.charAt(i))) stack.pop();
			else stack.push(s.charAt(i));
		}
		if (stack.isEmpty()) return true;
		return false;
	}

	private static boolean isPattern(Character c1, char c2) {
		if ((c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')')|| (c1 == '[' && c2 == ']')) return true;
		return false;
	}


	@Test
	public void myTests() {
		assertEquals(Groups.groupCheck("[{()}]"), true);
		assertEquals(Groups.groupCheck("({"), false);
	}

}
