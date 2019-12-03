package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:09
 * @description 创建一个Product对象的各个部件指定的抽象接口。
 */
public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }
}
