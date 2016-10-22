package test;

/**
 * Created by djt on 10/22/16.
 */
public class Person {
	String name;

	public Person(String personName) {
		name = personName;
	}

	public String greet(String yourName) {
		return String.format("Hi %s, my name is %s", name, yourName);
	}

	public static void main(String[] args) {
		System.out.println(new Person("ss").greet("hsa"));
	}
}
