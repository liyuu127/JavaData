package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 16:40
 * description ��������
 */
public class HJ6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextInt()) { // ע�� while ������ case
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
