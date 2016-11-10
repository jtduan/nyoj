package jtduan.classloader;

/**
 * Created by djt on 10/29/16.
 */
public class A {

	public A(){
		System.out.println("A is loaded by " + this.getClass().getClassLoader());
	}

}
