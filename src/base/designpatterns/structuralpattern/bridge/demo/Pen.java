package base.designpatterns.structuralpattern.bridge.demo;

/**
 * @author liyu
 * @date 2019/12/4 14:57
 * @description
 */
public abstract class Pen {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(String name);
}