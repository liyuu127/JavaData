package base.designpatterns.creationalpattern.factory.abstractfactory;

/**
 * @author liyu
 * @date 2019/12/3 14:16
 * @description 创建工厂接口
 */
public interface Factory {
    public Gun produceGun();
    public Bullet produceBullet();
}

