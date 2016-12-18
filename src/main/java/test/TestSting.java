package test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by djt on 10/29/16.
 */
public class TestSting {

	public static void main(String[] args) {
		Set<Inner> set = new HashSet<>();
		set.add(new Inner("abc",10));
		set.add(new Inner("bcd",20));
		System.out.println(set.size());
		set.remove(new Inner("abc",40));
		System.out.println(set.size());
		set.remove(new Inner("ppo",40));
		System.out.println(set.size());
	}
}

class Inner{
	String str;
	int val;

	public Inner(String str, int val) {
		this.str=str;
		this.val=val;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Inner inner = (Inner) o;

		return str != null ? str.equals(inner.str) : inner.str == null;

	}

	@Override
	public int hashCode() {
		return str != null ? str.hashCode() : 0;
	}
}