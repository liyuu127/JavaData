package base.designpatterns.structuralpattern.adapter;

/**
 * @author liyu
 * @date 2019/12/4 10:58
 * @description ÊÊÅäÆ÷Àà
 */
public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("adapter");
        adaptee.specificRequest();
    }
}
