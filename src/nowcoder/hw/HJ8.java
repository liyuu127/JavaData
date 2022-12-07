package nowcoder.hw;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author liyu
 * date 2022/12/7 17:07
 * description 合并表记录
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
            for (int i = 0; i < n; i++) {
                Integer key = in.nextInt();
                Integer value = in.nextInt();
                map.put(key, map.getOrDefault(key, 0) + value);
            }
            map.keySet().forEach(k -> System.out.println(k + " " + map.get(k)));
        }
    }
}
