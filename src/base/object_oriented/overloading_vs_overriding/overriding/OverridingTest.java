package base.object_oriented.overloading_vs_overriding.overriding;

/**
 * @author liyu
 * @date 2020/4/14 16:36
 * @description 重写的条件
 * 1.参数列表必须完全与被重写方法的相同；
 * 2.返回类型必须完全与被重写方法的返回类型相同；
 * 3.访问级别的限制性一定不能比被重写方法的强；访问级别的限制性可以比被重写方法的弱；
 * 4.重写方法一定不能抛出新的检查异常或比被重写的方法声明的检查异常更广泛的检查异常，重写的方法能够抛出更少或更有限的异常（也就是说，被重写的方法声明了异常，但重写的方法可以什么也不声明）
 * 5.不能重写被标示为final的方法；
 * 6.如果不能继承一个方法，则不能重写这个方法。
 */
public class OverridingTest {
    public static void main(String[] args) {
        Dog dog = new Hound();
        dog.bark();
    }
}
