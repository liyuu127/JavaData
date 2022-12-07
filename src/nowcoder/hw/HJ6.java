package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 16:40
 * description 质数因子
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a <= 1) {
                System.out.print(1);
            } else {
                for (int i = 2; i * i <= a; i++) {
                    while (a%i==0){
                        a/=i;
                        System.out.print(i+" ");
                    }
                }
                if(a!=1){
                    System.out.print(a);
                }
            }
        }
    }
}
