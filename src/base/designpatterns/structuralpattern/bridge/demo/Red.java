package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 15:00
 * @description
 */
public class Red implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "ºìÉ«µÄ" + name + ".");
    }
}
