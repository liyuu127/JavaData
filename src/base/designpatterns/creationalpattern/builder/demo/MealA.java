package base.designpatterns.creationalpattern.builder.demo;

/**
 * @author liyu
 * @date 2019/12/3 16:10
 * @description AÌ×²Í£º
 */
public class MealA extends MealBuilder{

    public void buildDrink() {
        meal.setDrink("¿ÉÀÖ");
    }

    public void buildFood() {
        meal.setFood("ÊíÌõ");
    }

}
