package algorithm.code.codewars;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by djt on 10/22/16.
 */
public class DuplicateEncoder {
	static String encode(String word){
		word=word.toLowerCase();
		Map<Character,Boolean> map = new HashMap<>();
		for(int i=0;i<word.length();i++){
			if(!map.containsKey(word.charAt(i)))map.put(word.charAt(i),false);
			else map.put(word.charAt(i),true);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<word.length();i++){
			if(map.get(word.charAt(i))) sb.append(')');
			else sb.append('(');
		}
		return sb.toString();
	}
}
