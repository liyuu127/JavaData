package nowcoder.hw;

import java.util.Scanner;

/**
 * @author liyu
 * date 2022/12/7 15:33
 * description 计算某字符出现次数
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            char c = Character.toLowerCase(in.nextLine().charAt(0));

            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c || (s.charAt(i) | 32) == c) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
