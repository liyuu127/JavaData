package algorithm.sort;

/**
 * @author liyu
 * date 2021/6/9 14:43
 * description
 */
public class Search {


    /**
     * 二分查找
     *
     * @param a     从小到大的数组
     * @param n     数组长度
     * @param value 待查找的值
     * @return
     */
    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归实现
     * @param a
     * @param n
     * @param val
     * @return
     */
    public int binarySearch0(int[] a, int n, int val) {
        return binarySearchInternally(a, 0, n - 1, val);
    }

    public int binarySearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearchInternally(a, mid + 1, high, value);
        } else {
            return binarySearchInternally(a, low, mid - 1, value);
        }
    }
}
