package base.designpatterns.behavioralpattern.strategy.java8;

import java.util.function.Predicate;

/**
 * @author liyu
 * @date 2019/12/9 10:15
 * @description
 */
public class Validator {
    private Predicate<String> predicate;

    public Validator(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    public boolean validate(String s) {
        return predicate.test(s);
    }
}
