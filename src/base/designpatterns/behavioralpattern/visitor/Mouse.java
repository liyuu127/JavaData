package base.designpatterns.behavioralpattern.visitor;

/**
 * @author liyu
 * @date 2019/12/9 15:11
 * @description
 */
public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
