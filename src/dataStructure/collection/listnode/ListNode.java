package dataStructure.collection.listnode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liyu
 * @date 2020/1/15 10:06
 * @description µ•œÚ¡¥±Ì
 */
@Getter
@Setter
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
}
