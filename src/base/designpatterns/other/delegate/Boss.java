package base.designpatterns.other.delegate;

/**
 * @author liyu
 * @date 2019/12/9 15:54
 * @description boss类模拟调用测试
 */
public class Boss {
    public static void main(String[] args) {
        Leader leader = new Leader();
        //看上去好像是我们的项目经理在干活
        //但实际干活的人是普通员工
        //这就是典型，干活是我的，功劳是你的
        leader.excute("登录");
        leader.excute("加密");
    }
}
