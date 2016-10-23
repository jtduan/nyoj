package algorithm.code.codewars;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Evaluator {
	public long evaluate(String s) {
		String[] strs = s.split(" ");
		Stack<Long> stack = new Stack<Long>();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].matches("-?[0-9]+")) stack.push(Long.parseLong(strs[i]));
			else if (strs[i].equals("+")) {
				long a = stack.pop();
				long b = stack.pop();
				stack.push(a + b);
			} else if (strs[i].equals("-")) {
				long a = stack.pop();
				long b = stack.pop();
				stack.push(b - a);
			} else if (strs[i].equals("*")) {
				long a = stack.pop();
				long b = stack.pop();
				stack.push(a * b);
			} else if (strs[i].equals("/")) {
				long a = stack.pop();
				long b = stack.pop();
				stack.push(b / a);
			}
		}
		return stack.pop();
	}

	@Test
	public void test1() throws Exception {
		Evaluator eval = new Evaluator();
		assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
	}
}
