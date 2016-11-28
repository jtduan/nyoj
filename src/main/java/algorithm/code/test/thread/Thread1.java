package algorithm.code.test.thread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static algorithm.code.test.thread.SharedClass.list;

/**
 * Created by djt on 11/14/16.
 */
public class Thread1 implements Runnable {
	@Override
	public void run() {
		int i=0;
		while (true) {
			i++;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (list) {
				System.out.println("Thread1 进入同步代码块");
				if(i==1){
//					list = new ArrayList<>(); //这段代码会导致锁的失效，每次都在一个新的对象上加锁
				}
				list.add(new MyLock());
				System.out.println(list.size());
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1 退出同步代码块");
			}
		}
	}
}
