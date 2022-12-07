package nowcoder.hw;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.*;

/**
 * @author liyu
 * date 2022/12/7 15:52
 * description 明明的随机数
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            Set<Integer> set = new TreeSet<>(Comparator.comparingInt(a->a));
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            set.forEach(System.out::println);

        }
    }
}
