package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 16:25
 * description 进制转换
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            System.out.println(Integer.valueOf(s.substring(2),16));
        }
    }
}
