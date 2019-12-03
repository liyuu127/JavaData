package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:15
 * @description
 */
public class M4A1Bullet implements Bullet {

    @Override
    public void load() {
        System.out.println("Load bullets with M4A1");
    }

}
