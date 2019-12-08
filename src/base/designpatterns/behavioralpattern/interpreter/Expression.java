package base.designpatterns.behavioralpattern.interpreter;

/**
 * @author liyu
 * @date 2019/12/8 14:14
 * @description 创建一个表达式接口
 */
public interface Expression {
    public boolean interpret(String context);
}
