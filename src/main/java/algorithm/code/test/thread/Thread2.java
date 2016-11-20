package algorithm.code.test.thread;

import java.util.concurrent.TimeUnit;

import static algorithm.code.test.thread.SharedClass.list;

/**
 * Created by djt on 11/14/16.
 */
public class Thread2 implements Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (list) {
				System.out.println("Thread2 进入同步代码块");
				list.add(new MyLock());
				System.out.println(list.size());
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread2 退出同步代码块");
			}
		}
	}
}
