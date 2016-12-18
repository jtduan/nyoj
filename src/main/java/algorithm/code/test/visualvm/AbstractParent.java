package algorithm.code.test.visualvm;

/**
 * @author jtduan
 * @date 2016/11/15
 */
public abstract class AbstractParent {

    public static synchronized void run() throws InterruptedException {
        System.out.println(get());
        Thread.sleep(1000);
        System.out.println(get());
    }
    public static String get(){
        return "parents";
    }

}
