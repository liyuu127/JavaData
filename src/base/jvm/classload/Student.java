package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 11:05
 * @description
 */
public class Student extends Person{
    private static  Integer b;
    static {
        System.out.println("Student.我是子类静态块，优先于构造块执行！ 并且只有创建第一个对象的时候执行一次！");
        Teacher teacher = new Teacher();
        b=teacher.a;
    }

    {
        System.out.println("Student.我是子类构造块，优先于构造方法执行！每创建一个对象执行一次！");
    }

    public Student() {
        System.out.println("Student.我是子类构造方法，每创建一个对象执行一次");
    }

    public void function1() {
        System.out.println("Student.我是子类非静态方法中的普通代码块， 方法被调用时执行！");
    }

    public static void function2() {
        System.out.println("Student.我是子类静态方法中的普通代码块，方法被调用时执行，晚于静态块执行！");
    }
}
