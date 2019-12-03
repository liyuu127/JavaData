package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 14:57
 * @description ConcreteBuilder（具体建造者）：实现抽象接口，构建和装配各个部件。
 */
public class ConcreteBuilder extends Builder{
    public void buildPartA(){
        System.out.println("A = " + "buildPartA");
    }
    public void buildPartB(){
        System.out.println("B = " + "buildPartB");
    }
    public void buildPartC(){
        System.out.println("C = " + "buildPartC");
    }
}
