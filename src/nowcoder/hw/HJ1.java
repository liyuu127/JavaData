package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 15:25
 * description 字符串最后一个单词的长度
 */
public class HJ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            int n = s.length();
            int i = s.lastIndexOf(" ");
            System.out.println(n - i - 1);


        }
    }
}
