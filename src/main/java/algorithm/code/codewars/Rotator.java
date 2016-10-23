package algorithm.code.codewars;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Rotator {

	public Object[] rotate2(Object[] data, int n) {
		int p=(n%data.length+data.length)%data.length;
		swap(data,0,data.length);
		swap(data,0,p);
		swap(data,p,data.length);
		return data;
	}
	public void swap(Object[] data,int start,int end){
		if(start==end) return;
		for(int i=start,j=end-1;i<j;i++,j--){
			Object temp = data[i];
			data[i]=data[j];
			data[j]=temp;
		}
	}



	public Object[] rotate(Object[] data, int n) {
		Collections.rotate(Arrays.asList(data), n);
		return data;
	}

	public static void main(String[] args) {
		System.out.println(-8%6);
		String[] data = new String[]{"sss","ccc"};
		List<String> list = Arrays.asList(data);
		list.set(1,"nnn");
		System.out.println(data[1]);
	}

//
//	private Rotator rotator;
//
//	@Before
//	public void setUp() {
//		this.rotator = new Rotator();
//	}
//
//	@After
//	public void tearDown() {
//		this.rotator = null;
//	}
//
//	@Test
//	public void testRotateOne_ArrayOfFive() {
//		assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 1));
//	}
//
//	@Test
//	public void testRotateTwo_ArrayOfFive() {
//		assertArrayEquals(new Object[]{4, 5, 1, 2, 3},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 2));
//	}
//
//	@Test
//	public void testRotateThree_ArrayOfFive() {
//		assertArrayEquals(new Object[]{3, 4, 5, 1, 2},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 3));
//	}
//
//	@Test
//	public void testRotateFour_ArrayOfFive() {
//		assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 4));
//	}
//
//	@Test
//	public void testRotateFive_ArrayOfFive() {
//		assertArrayEquals(new Object[]{1, 2, 3, 4, 5},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 5));
//	}
//
//	@Test
//	public void testRotateSix_ArrayOfFive() {
//		assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 6));
//	}
//
//	@Test
//	public void testRotateNegOne_ArrayOfFive() {
//		assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -1));
//	}
//
//	@Test
//	public void testRotateNegTwo_ArrayOfFive() {
//		assertArrayEquals(new Object[]{3, 4, 5, 1, 2},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -2));
//	}
//
//	@Test
//	public void testRotateNegThree_ArrayOfFive() {
//		assertArrayEquals(new Object[]{4, 5, 1, 2, 3},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -3));
//	}
//
//	@Test
//	public void testRotateNegFour_ArrayOfFive() {
//		assertArrayEquals(new Object[]{5, 1, 2, 3, 4},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -4));
//	}
//
//	@Test
//	public void testRotateNegFive_ArrayOfFive() {
//		assertArrayEquals(new Object[]{1, 2, 3, 4, 5},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -5));
//	}
//
//	@Test
//	public void testRotateNegSix_ArrayOfFive() {
//		assertArrayEquals(new Object[]{2, 3, 4, 5, 1},
//				rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -6));
//	}
}
