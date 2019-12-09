package base.designpatterns.other.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * @date 2019/12/9 15:53
 * @description leaderÎ¯ÅÉÕß
 */
public class Leader implements  IExcuter {

    private Map<String,IExcuter> targets = new HashMap<String,IExcuter>();
    public Leader() {
        targets.put("¼ÓÃÜ",new ExcuterA());
        targets.put("µÇÂ¼",new ExcuterB());
    }
    @Override
    public void excute(String command) {
        targets.get(command).excute(command);
    }
}
