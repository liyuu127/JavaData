package base.object_oriented.polymorphsim;

/**
 * @author liyu
 * @date 2020/4/14 16:26
 * @description 为了实现运行期的多态，或者说是动态绑定，需要满足三个条件。
 * 即有类继承或者接口实现、子类要重写父类的方法、父类的引用指向子类的对象。
 */
public class Test{

    public static void main(String[] args){
        Parent p = new Son(); //3.父类的引用指向子类的对象
        Parent p1 = new Daughter(); //3.父类的引用指向子类的对象
    }
}
