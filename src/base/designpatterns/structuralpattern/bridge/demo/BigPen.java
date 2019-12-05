package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 14:59
 * @description
 */
public class BigPen extends Pen {
    public void draw(String name) {
        String penType = "´óºÅÃ«±Ê»æÖÆ";
        this.color.bepaint(penType, name);
    }
}
