package algorithm.code.codewars;

import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */

public class DirReduction {
	public static String[] dirReduc(String[] arr) {
		Stack<String> stack = new Stack<String>();
		for(int i=0;i<arr.length;i++){
			if(!stack.isEmpty() && matches(stack.peek(),arr[i]))stack.pop();
			else stack.push(arr[i]);
		}
		return stack.toArray(new String[0]);
	}

	public static boolean matches(String a,String b){
		if(a=="EAST" && b=="WEST") return true;
		if(a=="WAST" && b=="EAST") return true;
		if(a=="NORTH" && b=="SOUTH") return true;
		if(a=="SOUTH" && b=="NORTH") return true;
		return false;
	}

	@Test
	public void testSimpleDirReduc() throws Exception {
		assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
				new String[]{"WEST"},
				DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));

		assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
				new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
				DirReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
	}
}
