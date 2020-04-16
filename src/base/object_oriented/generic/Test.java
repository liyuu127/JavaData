package base.object_oriented.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2020/4/16 14:22
 * @description
 */
public class Test {
    public static void main(String[] args) {
        List<? super Fruit> list = new ArrayList<>();
        list.add(new Apple("apple"));
        list.add(new Banana("banana"));
        list.add(new Fruit("fruit"));
        testExtend((List<? extends Fruit>) list);
    }

    public static void testExtend(List<? extends Fruit> list) {
        //报错,extends为上界通配符,只能取值,不能放.
        //因为Fruit的子类不只有Apple还有Banana,这里不能确定具体的泛型到底是Apple还是Banana，所以放入任何一种类型都会报错
        //list.add(new Apple());
//        list.add(new Banana())

//        Fruit fruit = list.get(0);
        list.forEach(Food::getName);
    }

    public void testSuper(List<? super Fruit> list) {
        list.add(new Apple("1"));
        //super为下界通配符，可以存放元素，但是也只能存放当前类或者子类的实例，以当前的例子来讲，
        //无法确定Fruit的父类是否只有Food一个(Object是超级父类)
        //因此放入Food的实例编译不通过
//        list.add(new Food("s"));
        Object object = list.get(0);
    }
}
