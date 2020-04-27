package leetCode.array.general;

/**
 * @author liyu
 * @date 2020/4/27 11:23
 * @description 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组?[0,1,2,4,5,6,7]?可能变为?[4,5,6,7,0,1,2]?)。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回?-1?。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是?O(log?n) 级别。
 * <p>
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 示例?2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length < 1) {
            return -1;
        }
        int left = 0, right = length - 1;
        while ((left <= right)) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }
}
