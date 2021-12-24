package leetCode.String;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * date 2021/12/23 16:23
 * description 最长重复子串
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 * <p>
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "banana"
 * 输出："ana"
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出：""
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-duplicate-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class longest_duplicate_substring {
    public static void main(String[] args) {
        String banana = longestDupSubstring("rtbbfywifhhthadpjixdeodqfgjfykvjwagudthnwfjdqyfskgczdzdsomkxfeizyfnmkirnklfevunbwvevymyoxcnddzhrqnengvjrptpgkusjfpcivknmpcptgbkosyujjcpqugnizpfqfxzrpyxmtbvpxqfbrrupmppkxyltyumcxtyefxjqlmpfymxvrbjmxvqtgnorweoujekkbpdzvhzvchdslcbmavwmjnlypoexhqoxfrnglcyhetrhpemrryhoanasaoyfxeznfeqkgqkzxcuphvngwryfouyugtrhxjfkegzgypucmpanrgyourwglemiclqkcubxbjzhkqzqextijwbfyizgylkyjxeuulkurebpovcxklywnwflnvmufbaauloekgtnabkvfvlsghtgqrkvopcablizoqdcxomhhyxtuwdebmjihmchdxtklvdecwvgogwwepqowfuwluklfiibyqaikphnfpfzhralzuuhsptonslvmkfojfdsumnwwacfwqxkotcqewulorinpzmhduhriisuajcpwjeanvyvpyefglpmfcicsglxtwadtrtaxnozxvchwagdyyinhqmhofuknauhwkinwzmrmermnnzndaxmqkgzotjgkxqhfqvgnvzymvcmdqpfiixrkmjpdbelzojbkjeublnwcdsckbpwbbwlloxhecimaysjzwbppgmzywbo1uicyjdcsaffcxxkmwoam2jzicswfzhccdlzewmzotyzprhreseqgmafkzkjqzwukrunckowdfajqhyrhhfhjfuzhvwgkwrmmpgribxqchowwvlbppnkofdfdennafqzawkycytghxehrjwdbrgroqfyoxynkketzkmglrsbqaxgfbiwhtuhzlpszsgbybawnguqhyadwteiikbahnhqdpvmobcsozloyyopxsnjlbgisytssbjbbuucqyvobnflnxtdrtbbfywifhhthadpjixdeodqfgjfykvjwagudthnwfjdqyfskgczdzdsomrtbbfywifhhthadpjixdeodqfgjfykvjwagu3dthnwfjdqyfskgczdzdsom");
        System.out.println("banana = " + banana);
    }
    public String longestDupSubstring(String s) {
        int n = s.length();
        int N = n + 10;
        int[] h = new int[N];
        int[] p = new int[N];
        int P = 131313;
        p[0] = 1;
        //s[i,j]=h[j]-h[i-1]*p[j-i+1]
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        for (int l = n - 1; l > 0; l--) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i + l - 1 <= n; i++) {
                int j = i + l - 1;
                int hash = h[j] - h[i - 1] * p[j - i + 1];
                if (map.getOrDefault(hash, 0) == 1) {
                    return s.substring(i-1, j);
                } else {
                    map.put(hash, 1);
                }
            }
        }
        return "";
    }
}
