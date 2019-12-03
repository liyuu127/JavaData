package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 14:31
 * @description Builder（抽象建造者）：创建一个Product对象的各个部件指定的抽象接口。
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}
