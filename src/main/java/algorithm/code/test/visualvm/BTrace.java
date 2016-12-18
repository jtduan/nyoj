//package algorithm.code.test.visualvm;
//
///**
// * @author jtduan
// * @date 2016/11/15
// */
//import com.sun.btrace.BTraceUtils;
//import static com.sun.btrace.BTraceUtils.*;
//import com.sun.btrace.annotations.*;
//
//@BTrace
//public class Btrace {
//
//    @OnMethod(
//            clazz = "algorithm.code.test.visualvm",
//            method = "add",
//            location = @Location(Kind.RETURN)//函数返回的时候执行，如果不填，则在函数开始的时候执行
//    )
//    public static void sayHello(String name, int age, @Return String result) {
//        println("name: " + name);
//        println("age: " + age);
//        println(result);
//    }
//
//}