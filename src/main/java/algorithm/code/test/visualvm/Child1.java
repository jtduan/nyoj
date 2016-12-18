package algorithm.code.test.visualvm;

import static algorithm.code.test.visualvm.Child1.lock;

/**
 * @author jtduan
 * @date 2016/11/15
 */
public class Child1 extends AbstractParent{
    public static String get() {
        return "child1";
    }
    public static Integer lock=new Integer(1034);

    public static void main(String[] args) throws InterruptedException {
//        int i=0;
//        synchronized (lock){
//            while(i<50) {
//                Thread.sleep(100);
//                i++;
//            }
//        }
        Thread t2 = new Thread(new MyThread());
        t2.start();
        t2.join();
        Thread t = new Thread(new MyThread());
        t.start();
        t.join();
        Thread t3 = new Thread(new MyThread());
        t3.start();
        t3.join();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        int i=0;
        synchronized (lock){
            while(i<50) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }
}