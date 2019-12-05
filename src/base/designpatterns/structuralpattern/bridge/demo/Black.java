package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 15:01
 * @description
 */
public class Black implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "ºÚÉ«µÄ" + name + ".");
    }
}
