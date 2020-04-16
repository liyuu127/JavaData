package base.object_oriented.generic;

/**
 * @author liyu
 * @date 2020/4/16 14:19
 * @description
 */
public class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public void getName(){
        System.out.println("name = " + this.name);
    }
}
