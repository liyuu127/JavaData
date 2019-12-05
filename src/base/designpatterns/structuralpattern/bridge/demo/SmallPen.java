package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 14:58
 * @description
 */
public class SmallPen extends Pen {
    public void draw(String name) {
        String penType = "Ğ¡ºÅÃ«±Ê»æÖÆ";
        this.color.bepaint(penType, name);
    }
}
