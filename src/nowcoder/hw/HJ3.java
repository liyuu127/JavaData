package nowcoder.hw;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.*;

/**
 * @author liyu
 * date 2022/12/7 15:52
 * description �����������
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // ע�� hasNext �� hasNextLine ������
        while (in.hasNextInt()) { // ע�� while ������ case
            int n = in.nextInt();
            Set<Integer> set = new TreeSet<>(Comparator.comparingInt(a->a));
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            set.forEach(System.out::println);

        }
    }
}
