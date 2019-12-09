package base.designpatterns.behavioralpattern.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyu
 * @date 2019/12/8 15:33
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
