package base.multithread;

/**
 * @author liyu
 * @date 2019/12/18 17:25
 * @description
 */
public class Test {

//    static volatile boolean flag = false;
    static boolean flag = false;

    public static  void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("flag = " + flag);
        });

        thread.start();
        thread.sleep(2000);
        flag = true;
        System.out.println("flag1 = " + flag);

    }

}
