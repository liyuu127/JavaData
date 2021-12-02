package leetCode.array.simple;

import lombok.experimental.UtilityClass;
import org.apache.tools.ant.types.resources.Intersect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author liyu
 * date 2021/12/2 11:02
 * description 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 * <p>
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *  
 * <p>
 * 提示：
 * <p>
 * n == score.length
 * 1 <= n <= 104
 * 0 <= score[i] <= 106
 * score 中的所有值 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class relative_ranks {
    public static void main(String[] args) {
        String[] relativeRanks = findRelativeRanks(new int[]{10, 3, 8, 9, 4});
        System.out.println("relativeRanks = " + Arrays.toString(relativeRanks));
    }

    public String[] findRelativeRanks(int[] score) {

        int length = score.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(score[i], i);
        }
        String answer[] = new String[length];
        Arrays.sort(score);
        for (int i = length - 1; i >= 0; i--) {
            int s = score[i];
            if (i == length - 1) {
                answer[map.get(s)] = "Gold Medal";
            } else if (i == length - 2) {
                answer[map.get(s)] = "Silver Medal";
            } else if (i == length - 3) {
                answer[map.get(s)] = "Bronze Medal";
            } else {
                answer[map.get(s)] = String.valueOf(length - i);
            }

        }
        return answer;

    }
}
