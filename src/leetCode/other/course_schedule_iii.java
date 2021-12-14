package leetCode.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liyu
 * date 2021/12/14 14:25
 * description  Course Schedule III
 * There are n different online courses numbered from 1 to n.
 * You are given an array courses where courses[i] = [durationi, lastDayi]
 * indicate that the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 * Return the maximum number of courses that you can take.
 * <p>
 * Example 1:
 * Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
 * Output: 3
 * Explanation:
 * There are totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days so you will finish it on the 100th day, and ready to take the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on the 1101st day.
 * Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 * <p>
 * Example 2:
 * Input: courses = [[1,2]]
 * Output: 1
 * Example 3:
 * <p>
 * Input: courses = [[3,2],[4,3]]
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class course_schedule_iii {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((c1, c2) -> c2[0] - c1[0]);

        int day = 0;
        for (int i = 0; i < courses.length; i++) {
            if (day + courses[i][0] <= courses[i][1]) {
                queue.offer(courses[i]);
                day += courses[i][0];
            } else if (!queue.isEmpty() && queue.peek()[0] > courses[i][0]) {
                day -= queue.poll()[0];
                queue.offer(courses[i]);
                day += courses[i][0];
            }
        }
        return queue.size();

    }
}
