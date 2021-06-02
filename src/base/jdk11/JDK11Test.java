package base.jdk11;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDK11Test {
    public static void main(String[] args) {
        //1、本地变量类型推断
        var s = "javastack";
        System.out.println("s = " + s);

        //  2、字符串加强
        // 判断字符串是否为空白  
        " ".isBlank();// true  
        // 去除首尾空格  
        " Javastack ".strip();// "Javastack"  
        // 去除尾部空格   
        " Javastack ".stripTrailing();// " Javastack"  
        // 去除首部空格   
        " Javastack ".stripLeading();// "Javastack "  
        // 复制字符串  
        "Java".repeat(3);// "JavaJavaJava"  
        // 行数统计  
        "A\nB\nC".lines().count();// 3 

        //3、集合加强
        var list = List.of("Java", "Python", "C");
        var copy = List.copyOf(list);
        System.out.println(list == copy);// true 

        //4、Stream 加强
        //增加单个参数构造方法，可为null
        Stream.ofNullable(null).count();
        //增加 takeWhile 和 dropWhile 方法
        List<Integer> collect = Stream.of(1, 2, 3, 2, 1)
                .takeWhile(n -> n < 3) //从开始计算，当 n < 3 时就截止
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
        List<Integer> collect2 = Stream.of(1, 2, 3, 2, 1)
                .dropWhile(n -> n < 3) //一旦 n < 3 不成立就开始计算
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }
}
