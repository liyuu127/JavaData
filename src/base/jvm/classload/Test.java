package base.jvm.classload;

/**
 * @author liyu
 * @date 2019/12/6 16:37
 * @description
 */
public class Test {
    public static void main(String[] args) {
//        Student student = new Student();
//        student.function1();

        Teacher teacher = new Teacher();
        teacher.function1();
        System.out.println("teacher = " + teacher);
        teacher.function11();

//        Person person = new Person();
//        person.function1();
//        person.function11();
    }
}
