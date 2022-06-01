package leetCode.backtracking.gen;

import java.util.Arrays;

/**
 * @author liyu
 * date 2022/6/1 9:38
 * description 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * 示例1:
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例2:
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形
 * 提示:
 *
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/matchsticks-to-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class matchsticks_to_square {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).reduce(0, (x, y) -> x + y);
        if (sum % 4 != 0) return false;
        int length = sum / 4;
        Arrays.sort(matchsticks);
        int[] edges = new int[4];
        return dfs(matchsticks.length - 1, matchsticks, edges, length);


    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index - 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    public boolean makesquare0(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                //k位未放入
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

}
