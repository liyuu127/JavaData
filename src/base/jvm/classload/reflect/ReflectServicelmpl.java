package base.jvm.classload.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liyu
 * @date 2019/12/5 15:26
 * @description
 */
@Data
@AllArgsConstructor
public class ReflectServicelmpl {
    private String param;
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
}
