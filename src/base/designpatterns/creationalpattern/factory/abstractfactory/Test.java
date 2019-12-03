package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:18
 * @description ≤‚ ‘
 */
public class Test {

    public static void main(String[] args) {

        Factory factory;
        Gun gun;
        Bullet bullet;

        factory =new AKFactory();
        bullet=factory.produceBullet();
        bullet.load();
        gun=factory.produceGun();
        gun.shooting();

    }

}
