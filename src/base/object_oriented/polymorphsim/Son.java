package base.object_oriented.polymorphsim;

/**
 * @author liyu
 * @date 2020/4/14 16:25
 * @description
 */
public class Son extends Parent{// 1.有类继承或者接口实现
    public void call(){// 2.子类要重写父类的方法
        System.out.println("im Son");
    }
}
