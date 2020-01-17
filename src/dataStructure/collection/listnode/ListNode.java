package dataStructure.collection.listnode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liyu
 * @date 2020/1/15 10:06
 * @description µ¥ÏòÁ´±í
 */
@Getter
@Setter
public class ListNode {
    private Integer data;
    private ListNode next;

    public ListNode(Integer data) {
        this.data = data;
    }
}
