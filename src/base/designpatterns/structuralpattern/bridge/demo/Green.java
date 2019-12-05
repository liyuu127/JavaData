package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 15:00
 * @description
 */
public class Green implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "бли╚╣д" + name + ".");
    }
}