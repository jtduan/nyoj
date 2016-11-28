package algorithm.code.leetcode;

import java.util.Stack;

/**
 * Created by djt on 11/20/16.
 */
public class L331 {

	public boolean isValidSerialization(String preorder) {
		Stack<Integer> stack = new Stack<>();
		String[] chars = preorder.split(",");
		for(int i=0;i<chars.length;i++){
			if(!chars[i].equals("#")){
				stack.push(0);
				continue;
			}
			if(chars[i].equals("#")){
				while(!stack.isEmpty() && stack.peek()==1){
					stack.pop();
				}
				if(stack.isEmpty() && i==chars.length-1) return true;
				if(stack.isEmpty()) return false;
				stack.pop();
				stack.push(1);
			}
		}
		return false;
	}
}
