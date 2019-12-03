package base.designpatterns.creationalpattern.builder;

import lombok.Data;

/**
 * @author liyu
 * @date 2019/12/3 14:30
 * @description Product（产品角色）：一个具体的产品对象。
 */
@Data
public class Product {
    private String partA; //可以是任意类型
    private String partB;
    private String partC;
}
