package base.designpatterns.structuralpattern.proxy.cglib;

/**
 * @author liyu
 * @date 2019/12/5 18:19
 * @description
 */
public class Test {
    public static void main(String[] args) {
        CglibProxyExample cglibProxyExample = new CglibProxyExample();
        Student student = (Student) cglibProxyExample.getProxy(Student.class, new Class[]{String.class, Integer.class}, new Object[]{"name", 18});
        String s = student.introduce("liyu");
        System.out.println("s = " + s);
    }
}
