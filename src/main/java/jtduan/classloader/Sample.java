package jtduan.classloader;

/**
 * Created by djt on 10/29/16.
 */
public class Sample {

	public static int num = 0;

	public Sample() {
		System.out.println("Sample is loaded by " + this.getClass().getClassLoader());
		new A();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
