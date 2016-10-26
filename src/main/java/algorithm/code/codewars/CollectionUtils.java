package algorithm.code.codewars;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by djt on 10/23/16.
 */
public class CollectionUtils {

	public static List<Object> flattenList(List<Object> list) {
		if(list==null) return Collections.EMPTY_LIST;
		List<Object> res = new ArrayList<>();
		for(Object obj:list){
			if(obj instanceof List){
				res.addAll(flattenList((List)obj));
			}
			else if(obj instanceof Set){
				res.addAll(flattenList(new ArrayList<Object>((Set)obj)));
			}
			else{
				res.add(obj);
			}
		}
		return res;
	}
	@Test
	public void testEmpty() {
		List<Object> emptyList = CollectionUtils.flattenList(null);
		Assert.assertArrayEquals(new Object[0], emptyList.toArray());
	}

	@Test
	public void testFlattening() {
		List<Object> nestedList = new ArrayList<>();
		nestedList.add(5);
		List<Object> innerList2 = Arrays.asList(14,13,12);
		List<Object> innerList = new ArrayList<>();
		innerList.add(4);
		innerList.add(3);
		innerList.add(innerList2);
		nestedList.add(innerList);

		List<Object> list = CollectionUtils.flattenList(nestedList);
		List<Object> testList = Arrays.asList(5,4,3,14,13,12);
		Assert.assertArrayEquals(testList.toArray(), list.toArray());

	}

}
