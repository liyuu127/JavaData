package leetCode.array.simple;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/11/8 10:57
 * @description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例?2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int i = searchInsert(nums, target);
        System.out.println("i = " + i);
        int index = Arrays.binarySearch(nums, target);
        if(index>0){
            System.out.println("index = " + index);
        }else {
            index=-index-1;
            System.out.println("-index = " + index);
        }
    }

    //暴力遍历
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for (; i < nums.length && nums[i] < target; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return i;
    }

    //二分查找实现
    public static int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
