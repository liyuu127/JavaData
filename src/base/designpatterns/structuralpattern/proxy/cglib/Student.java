package base.designpatterns.structuralpattern.proxy.cglib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyu
 * @date 2019/12/5 18:09
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer age;

    public String introduce(String className){
        return "–’√˚: "+name+"£¨ƒÍ¡‰£∫"+age+"∞‡º∂£∫"+className;
    }

}
