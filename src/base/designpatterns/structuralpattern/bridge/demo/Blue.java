package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 15:02
 * @description
 */
public class Blue implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "À¶É«µÄ" + name + ".");
    }
}
