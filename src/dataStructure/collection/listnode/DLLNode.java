package dataStructure.collection.listnode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liyu
 * @date 2020/1/15 10:59
 * @description 双向链表结点
 */
@Getter
@Setter
public class DLLNode {
    private int data;
    private DLLNode previous;
    private DLLNode next;

    public DLLNode(int data) {
        this.data = data;
    }
}
