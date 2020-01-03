package algorithm.recursion;

/**
 * @author liyu
 * @date 2020/1/3 11:59
 * @description 数组是否递增
 */
public class IsArrayInSortedOrder {
    public static void main(String[] args) {
        int arrayInSortedOrder = isArrayInSortedOrder(new int[]{1, 2, 3, 4, 5}, 4);
        System.out.println("arrayInSortedOrder = " + arrayInSortedOrder);
    }

    public static int isArrayInSortedOrder(int[] A, int index) {
        if (index == 2) {
            return A[index - 1] <= A[index - 2] ? 1 : 0;
        }
        return (A[index - 1] <= A[index - 2]) ? 1 : isArrayInSortedOrder(A, index - 1);
    }
}
