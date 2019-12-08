package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 11:04
 * @description
 */
public class Person {
    static {
        System.out.println("1.我是父类静态块，优先于构造块执行！ 并且只有创建第一个对象的时候执行一次！");
    }

    {
        System.out.println("2.我是父类构造块，优先于构造方法执行！每创建一个对象执行一次！");
    }

    public Person() {
        System.out.println("3.我是父类构造方法，每创建一个对象执行一次");
    }

    public void function1() {
        System.out.println("我是父类非静态方法中的普通代码块， 方法被调用时执行！");
    }

    public static void function2() {
        System.out.println("我是父类静态方法中的普通代码块，方法被调用时执行，晚于静态块执行！");
    }
}
