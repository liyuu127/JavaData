package base.designpatterns.structuralpattern.facade;

/**
 * @author liyu
 * @date 2019/12/5 11:42
 * @description Disk子系统类
 */
public class Disk {
    public void start() {
        System.out.println("Disk is start...");
    }

    public void shutDown() {
        System.out.println("Disk is shutDown...");
    }
}
