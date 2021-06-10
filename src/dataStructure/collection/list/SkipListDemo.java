package dataStructure.collection.list;

/**
 * @author liyu
 * date 2021/6/10 10:21
 * description
 */
public class SkipListDemo {
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(12);
        skipList.insert(9);
        skipList.insert(1);
        skipList.insert(24);
        skipList.insert(28);
        skipList.insert(26);
        skipList.insert(10);
        skipList.insert(17);
        skipList.insert(7);
    }
}
