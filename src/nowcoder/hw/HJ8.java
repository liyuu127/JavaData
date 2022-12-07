package nowcoder.hw;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author liyu
 * date 2022/12/7 17:07
 * description �ϲ����¼
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextInt()) { // ע�� while ������ case
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
