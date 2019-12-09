package base.designpatterns.behavioralpattern.visitor;

/**
 * @author liyu
 * @date 2019/12/9 15:10
 * @description
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
