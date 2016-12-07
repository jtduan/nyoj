package awesome;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 * JAVA正则表达式替换
 */
public class Abbreviator {

	public String abbreviate(String string) {
		int left=0;
		int right=0;
		StringBuilder sb = new StringBuilder();
		while(right<string.length()){
			while(right<string.length() && isCharacter(string.charAt(right))){
				right++;
			}
			if(right-left>=4){
				sb.append(string.charAt(left)).append(right-left-2).append(string.charAt(right-1));
				if(right<string.length()){
					sb.append(string.charAt(right));
				}
			}
			else{
				sb.append(string.substring(left,Math.min(right+1,string.length())));
			}
			right++;
			left=right;
		}
		return sb.toString();
	}

	private boolean isCharacter(char c) {
		return String.valueOf(c).matches("\\w");


	}


	public String abbreviate2(String string) {
		Matcher m = Pattern.compile("(\\w+)").matcher(string);

		StringBuffer sb = new StringBuffer();
		while (m.find())
			m.appendReplacement(sb, Matcher.quoteReplacement(abbreviateWord(m.group(1))));
		m.appendTail(sb);
		return sb.toString();
	}

	private static String abbreviateWord(String string) {
		if (string.length() <= 3)
			return string;

		return String.format("%c%d%c", string.charAt(0), string.length() - 2, string.charAt(string.length()-1));
	}

	@Test
	public void testInternationalization() {
		assertEquals("e6t-r3s are r4y fun!", abbreviate("elephant-rides are really fun!"));
	}
}
