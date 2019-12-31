package algorithm.sort;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2019/12/30 15:14
 * @description 常见的十种排序算法实现
 */
public class Sort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 3, 7, 1, 2, 9, 8, 0, 4};
        System.out.println("排序前arr=" + Arrays.toString(arr));
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
//        shellSort(arr);
//        mergeSort(arr);
//        quickSort(arr);
//        heapSort(arr);
//        countSort(arr);
//        bucketSort(arr);
        radixSort(arr);
        System.out.println("排序后arr=" + Arrays.toString(arr));

    }


    /**
     * 冒泡排序
     * 通过从左到右不断交换相邻逆序的相邻元素，在一轮的交换之后，可以让未排序的元素上浮到右侧。
     * 在一轮循环中，如果没有发生交换，就说明数组已经是有序的，此时可以直接退出。
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }

    }

    /**
     * 选择排序
     * 选择出数组中的最小元素，将它与数组的第一个元素交换位置。再从剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。不断进行这样的操作，直到将整个数组排序
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 插入排序
     * 插入排序从左到右进行，每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左部数组依然有序。
     * 第 j 元素是通过不断向左比较并交换来实现插入过程：当第 j 元素小于第 j - 1 元素，就将它们的位置交换，然后令 j 指针向左移动一个位置，不断进行以上操作。
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//
//            for (int j = i + 1; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }

        // 改进版插入排序（减少了数组元素的操作次数
        for (int i = 0; i < arr.length; i++) {
            int e = arr[i];
            int j = i;
            for (; j > 0; j--) {
                if (e < arr[j - 1])
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = e;
        }
    }

    /**
     * 希尔排序
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        //实现1
//        int step = 1;
//        while (step < arr.length) {
//            step = step * 3 + 1;
//        }
//
//        while (step > 0) {
//            for (int i = step; i < arr.length; i++) {
//                int j = i - step;
//                while (j >= 0 && arr[j + step] < arr[j]) {
//                    swap(arr, j + step, j);
//                    j -= step;
//                }
//
//            }
//            step = Math.floorDiv(step, 3);
//        }

        //实现2
        int n = arr.length;
        for (int h = n / 2; h > 0; h = h / 2) {
            // 内部是一个插入排序
            for (int i = 0; i < n; i = i + h) {

                int e = arr[i];
                int j = i;
                for (; j > 0; j = j - h) {
                    if (e < arr[j - h]) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = e;
            }
        }

    }

    /**
     * 归并排序
     * 归并方法将数组中两个已经排序的部分归并成一个
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);

//        自底向上归并排序
//        int N = arr.length;
//        int[] aux = new int[N];
//        for (int sz = 1; sz < N; sz += sz)
//            for (int i = 0; i + sz < N; i += sz + sz)
//                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, N - 1));
    }

    /**
     * 对指定范围的数组进行归并排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    /**
     * 快速排序
     * 快速排序是原地排序，不需要辅助数组，但是递归调用需要辅助栈。
     * 快速排序最好的情况下是每次都正好能将数组对半分，这样递归调用次数才是最少的。这种情况下比较次数为 CN=2CN/2+N，复杂度为 O(NlogN)。
     * 最坏的情况下，第一次从最小的元素切分，第二次从第二小的元素切分，如此这般。因此最坏的情况下需要比较 N2/2。为了防止数组最开始就是有序的，在进行快速排序时需要随机打乱数组。
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition2(arr, l, r);
//        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }


    /**
     * 将数组通过p分割成两部分
     * 对arr[l...r]部分进行partition操作
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r) {
//        swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);  // 加入这一行变成随机快速排序

        // 设定基准值（v）
        int v = arr[l];
        int j = l;
        for (int i = j + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }


    /**
     * 双路快速排序的partition
     * 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     * 若果数组中含有大量重复的元素，则partition很可能把数组划分成两个及其不平衡的两部分，时间复杂度退化成O(n?)。这时候应该把小于v和大于v放在数组两端。
     *
     * @param arr 排序数组
     * @param l   左边界
     * @param r   右边界
     * @return
     */
    private static int partition2(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        // swap(arr, l, (int) (Math.random() % (r - l + 1)) + l);

        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while (i <= r && arr[i] < v)
                i++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while (j >= l + 1 && arr[j] > v)
                j--;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html
            if (i > j)
                break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);

        return j;
    }

    /**
     * 三路快速排序
     * 数组分成三个部分，大于v 等于v 小于v
     * 在具有大量重复键值对的情况下使用三路快排
     * 递归使用快速排序,对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort3Ways(int[] arr, int l, int r) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        int v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;    // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

    /**
     * 堆排序
     * 创建一个堆 H[0……n-1]；
     * 把堆首（最大值）和堆尾互换；
     * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
     * 重复步骤 2，直到堆的尺寸为 1。
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {

        int len = arr.length;
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return;
    }

    /**
     * 构建最大堆
     *
     * @param arr
     * @param len
     */
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    /**
     * 调整堆结点
     *
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    /**
     * 计数排序
     * 花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
     * 开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
     * 数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
     * 最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
     *
     * @param arr
     */
    public static void countSort(int[] arr) {
        int maxValue = getMaxValue(arr);
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }

    }

    /**
     * 返回数组中最大值
     *
     * @param arr
     * @return
     */
    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * 桶排序
     * 设置固定数量的空桶。
     * 把数据放到对应的桶中。
     * 对每个不为空的桶中数据进行排序。
     * 拼接不为空的桶中数据，得到结果
     *
     * @param arr
     */
    public static void bucketSort(int[] arr) {
        int bucketSize = 5;
        bucketSort(arr, bucketSize);
    }

    /**
     * 桶排序
     * 指定桶数
     *
     * @param arr
     * @param bucketSize
     */
    public static void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     * @return
     */
    private static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 基数排序
     * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
     * 从最低位开始，依次进行一次排序
     * 从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int mod = 10;
        int dev = 1;
        int maxDigit = getMaxDigit(arr);

         for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter =  new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return;
    }

    /**
     * 获取数组最高位数
     *
     * @param arr
     * @return
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    /**
     * 获取数值位数
     *
     * @param num
     * @return
     */
    private static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    /**
     * 交换数组中的i，j
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
