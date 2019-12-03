package base.designpatterns.creationalpattern.builder;

/**
 * @author liyu
 * @date 2019/12/3 16:04
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
    }
}
