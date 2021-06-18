package dataStructure.collection.heap;

/**
 * @author liyu
 * date 2021/6/18 11:17
 * description 大顶堆
 */
public class Heap {

    private int a[];
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }


    /**
     * 插入数据 按照自下向上的方式进行堆化
     *
     * @param data
     */
    public void insert(int data) {
        if (count >= n) {
            throw new IndexOutOfBoundsException();
        }
        count++;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 移除堆顶元素
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    /**
     * 自顶向下堆化
     *
     * @param a
     * @param n
     * @param i
     */
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[i] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    /**
     * 构建堆
     *
     * @param a
     * @param n
     */
    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
