package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 15:25
 * description �ַ������һ�����ʵĳ���
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextLine()) { // ע�� while ������ case
            String s = in.nextLine();
            int n = s.length();
            int i = s.lastIndexOf(" ");
            System.out.println(n - i - 1);


        }
    }
}
