package algorithm.code.java;

/**
 * @author jtduan
 * @date 2016/10/12
 *
 * 静态方法和属性子类不会继承，但是可以直接访问（private除外）
 */
public class Child extends Parent{
    private static int num =12;
    public static int child_get(){
        return get();
    }

    public static void main(String[] args) {
        System.out.println(Child.child_get());
    }
}
