package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:53
 * @description 普通员工B
 */
public class ExcuterB implements IExcuter {
    @Override
    public void excute(String command) {
        System.out.println("员工B 开始做" + command + "的工作");
    }
}
