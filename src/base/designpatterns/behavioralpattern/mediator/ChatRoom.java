package base.designpatterns.behavioralpattern.mediator;

import java.util.Date;

/**
 * @author liyu
 * @date 2019/12/8 15:33
 * @description
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
