package base.designpatterns.behavioralpattern.strategy.java8;

/**
 * @author liyu
 * @date 2019/12/9 10:15
 * @description
 */
public class Test {
    public static void main(String[] args) {
        Validator numericValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println("b1 = " + b1);
        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println("b2 = " + b2);
    }
}
