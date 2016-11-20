package algorithm.code.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djt on 11/14/16.
 *
 * 被加锁的 对象最好是基本类型，（相当于Final类型，不会被改变）
 * 被加锁的对象为引用时，若其他非同步方法 或者同步方法内部 修改该引用的指向，会导致锁的失效
 *
 * 非同步的get方法 也应该返回 引用的浅拷贝，这样当get方法修改引用时，不会修改被同步的对象
 */
public class SharedClass {
	private int x;
	public static List<MyLock> list = new ArrayList<>();

	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		list = new ArrayList<>();
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

