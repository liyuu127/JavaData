package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:52
 * @description 普通员工A
 */
public class ExcuterA implements IExcuter {

    @Override
    public void excute(String command) {
        System.out.println("员工A 开始做" + command + "的工作");
    }
}
