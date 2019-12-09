package base.designpatterns.behavioralpattern.visitor;

/**
 * @author liyu
 * @date 2019/12/9 15:09
 * @description 定义一个表示元素的接口
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
