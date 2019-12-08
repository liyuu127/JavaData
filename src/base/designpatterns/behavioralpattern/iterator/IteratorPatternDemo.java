package base.designpatterns.behavioralpattern.iterator;

/**
 * @author liyu
 * @date 2019/12/8 15:18
 * @description
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
