package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:11
 * @description BÌ×²Í£º
 */
public class MealB extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("ÄûÃÊ¹ûÖ­");
    }

    public void buildFood() {
        meal.setFood("¼¦³á");
    }

}
