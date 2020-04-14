package base.object_oriented.overloading_vs_overriding.overloading;

/**
 * @author liyu
 * @date 2020/4/14 16:40
 * @description 重载的条件
 * 1.被重载的方法必须改变参数列表；
 * 2.被重载的方法可以改变返回类型；
 * 3.被重载的方法可以改变访问修饰符；
 * 4.被重载的方法可以声明新的或更广的检查异常；
 * 5.方法能够在同一个类中或者在一个子类中被重载。
 */
class Dog {
    public void bark() {
        System.out.println("woof ");
    }

    //overloading method
    public void bark(int num) {
        for (int i = 0; i < num; i++)
            System.out.println("woof ");
    }
}

