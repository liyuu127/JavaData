package leetCode.other;

import java.util.*;

public class an_zhuang_zha_lan {

    /**
     * Jarvis 算法
     * 首先必须要从凸包上的某一点开始，比如从给定点集中最左边的点开始，例如最左的一点 A1。
     * 然后选择 A2点使得所有点都在向量 A1A2的左方或者右方，我们每次选择左方，需要比较所有点以 A1为原点的极坐标角度。
     * 然后以 A2为原点，重复这个步骤，依次找到 A3,A4,...,Ak
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param trees
     * @return
     */
    public int[][] outerTrees1(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int leftMost = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i][0] < trees[leftMost][0]) {
                leftMost = i;
            }
        }

        List<int[]> res = new ArrayList<int[]>();
        boolean[] visit = new boolean[n];
        int p = leftMost;
        do {
            int q = (p + 1) % n;
            for (int r = 0; r < n; r++) {
                /* 如果 r 在 pq 的右侧，则 q = r */
                if (cross(trees[p], trees[q], trees[r]) < 0) {
                    q = r;
                }
            }
            /* 是否存在点 i, 使得 p 、q 、i 在同一条直线上 */
            for (int i = 0; i < n; i++) {
                if (visit[i] || i == p || i == q) {
                    continue;
                }
                if (cross(trees[p], trees[q], trees[i]) == 0) {
                    res.add(trees[i]);
                    visit[i] = true;
                }
            }
            if (!visit[q]) {
                res.add(trees[q]);
                visit[q] = true;
            }
            p = q;
        } while (p != leftMost);
        return res.toArray(new int[][]{});
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    /**
     * Graham 算法
     * 这个方法的具体实现为：首先选择一个凸包上的初始点 bottom。
     * 我们选择 y 坐标最小的点为起始点，我们可以肯定 bottom 一定在凸包上，将给定点集按照相对的以 bottom 为原点的极角大小进行排序。
     * 这一排序过程大致给了我们在逆时针顺序选点时候的思路。为了将点排序，我们使用函数 cross 。极角顺序更小的点排在数组的前面。
     * 如果有两个点相对于点bottom 的极角大小相同，则按照与点 bottom 的距离排序。
     * 我们还需要考虑另一种重要的情况，如果共线的点在凸壳的最后一条边上，我们需要从距离初始点最远的点开始考虑起。
     * 所以在将数组排序后，我们从尾开始遍历有序数组并将共线且朝有序数组尾部的点反转顺序，因为这些点是形成凸壳过程中尾部的点，
     * 所以在经过了这些处理以后，我们得到了求凸壳时正确的点的顺序。
     * 现在我们从有序数组最开始两个点开始考虑。我们将这条线上的点放入栈中。
     * 然后我们从第三个点开始遍历有序数组 trees。
     * 如果当前点与栈顶的点相比前一条线是一个「左拐」或者是同一条线段上，我们都将当前点添加到栈顶，表示这个点暂时被添加到凸壳上。
     * 检查左拐或者右拐使用的还是 cross 函数。
     * 对于向量 pq,qr如果叉积小于 0，可以知道向量pq,qr顺时针旋转，则此时向右拐；
     * 如果叉积大于 0，可以知道向量pq,qr时针旋转，表示是左拐；
     * 如果叉积等于 0，则 p,q,r 在同一条直线上。
     * 如果当前点与上一条线之间的关系是右拐的，说明上一个点不应该被包括在凸壳里，因为它在边界的里面，
     * 所以我们将它从栈中弹出并考虑倒数第二条线的方向。
     * 重复这一过程，弹栈的操作会一直进行，直到我们当前点在凸壳中出现了右拐。
     * 这表示这时凸壳中只包括边界上的点而不包括边界以内的点。在
     * 所有点被遍历了一遍以后，栈中的点就是构成凸壳的点。
     *
     * @param trees
     * @return
     */
    public int[][] outerTrees2(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        int bottom = 0;
        /* 找到 y 最小的点 bottom*/
        for (int i = 0; i < n; i++) {
            if (trees[i][1] < trees[bottom][1]) {
                bottom = i;
            }
        }
        swap(trees, bottom, 0);
        /* 以 bottom 原点，按照极坐标的角度大小进行排序 */
        Arrays.sort(trees, 1, n, (a, b) -> {
            int diff = cross(trees[0], a, b) - cross(trees[0], b, a);
            if (diff == 0) {
                return distance(trees[0], a) - distance(trees[0], b);
            } else {
                return -diff;
            }
        });
        /* 对于凸包最后且在同一条直线的元素按照距离从小到大进行排序 */
        int r = n - 1;
        while (r >= 0 && cross(trees[0], trees[n - 1], trees[r]) == 0) {
            r--;
        }
        for (int l = r + 1, h = n - 1; l < h; l++, h--) {
            swap(trees, l, h);
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        stack.push(1);
        for (int i = 2; i < n; i++) {
            int top = stack.pop();
            /* 如果当前元素与栈顶的两个元素构成的向量顺时针旋转，则弹出栈顶元素 */
            while (!stack.isEmpty() && cross(trees[stack.peek()], trees[top], trees[i]) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(i);
        }

        int size = stack.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[stack.pop()];
        }
        return res;
    }


    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    public void swap(int[][] trees, int i, int j) {
        int temp0 = trees[i][0], temp1 = trees[i][1];
        trees[i][0] = trees[j][0];
        trees[i][1] = trees[j][1];
        trees[j][0] = temp0;
        trees[j][1] = temp1;
    }


    /**
     * Andrew 算法
     * Andrew 使用单调链算法，该算法与 Graham 扫描算分类似。
     * 它们主要的不同点在于凸壳上点的顺序。与 Graham 扫描算法按照点计较顺序排序不同，
     * 我们按照点的 x 坐标排序，如果两个点又相同的 x 坐标，那么就按照它们的 y 坐标排序。
     * 显然排序后的最大值与最小值一定在凸包上，而且因为是凸多边形，
     * 我们如果从一个点出发逆时针走，轨迹总是「左拐」的，一旦出现右拐，就说明这一段不在凸包上，因此我们可以用一个单调栈来维护上下凸壳。
     * 仔细观察可以发现，最大值与最小值一定位于凸包的最左边与最右边，
     * 从左向右看，我们将凸壳考虑成 2 个子边界组成：上凸壳和下凸壳。
     * 下凸壳一定是从最小值一直「左拐」直到最大值，上凸壳一定是从最大值「左拐」到最小值，因此我们首先升序枚举求出下凸壳，然后降序求出上凸壳。
     * 我们首先将最初始的两个点添加到凸壳中，然后遍历排好序的 trees 数组。
     * 对于每个新的点，我们检查当前点是否在最后两个点的逆时针方向上，轨迹是否是左拐。
     * 如果是的话，当前点直接被压入凸壳 hull 中，cross 返回的结果为正数；
     * 如果不是的话，cross 返回的结果为负数，我们可以知道栈顶的元素在凸壳里面而不是凸壳边上。
     * 我们继续从 hull 中弹出元素直到当前点相对于栈顶的两个点的逆时针方向上。
     * 这个方法中，我们不需要显式地考虑共线的点，因为这些点已经按照 x 坐标排好了序。所以如果有共线的点，它们已经被隐式地按正确顺序考虑了。通
     * 过这样，我们会一直遍历到 x 坐标最大的点为止。但是凸壳还没有完全求解出来。
     * 目前求解出来的部分只包括凸壳的下半部分。现在我们需要求出凸壳的上半部分。
     * 我们继续找下一个逆时针的点并将不在边界上的点从栈中弹出，
     * 但这次我们遍历的顺序是按照 x 坐标从大到小，我们只需要从后往前遍历有序数组 trees 即可。
     * 我们将新的上凸壳的值添加到之前的 hull 数组中。
     * 最后 hull 数组返回了我们需要的边界上的点。
     * 需要注意的是，由于我们需要检测上凸壳最后加入的点是否合法，此时需要再次插入最左边的点 hull[0] 进行判别。
     * @param trees
     * @return
     */
    public int[][] outerTrees3(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        /* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<Integer> hull = new ArrayList<Integer>();
        boolean[] used = new boolean[n];
        /* hull[0] 需要入栈两次，不进行标记 */
        hull.add(0);
        /* 求出凸包的下半部分 */
        for (int i = 1; i < n; i++) {
            while (hull.size() > 1 && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.get(hull.size() - 1)] = false;
                hull.remove(hull.size() - 1);
            }
            used[i] = true;
            hull.add(i);
        }
        int m = hull.size();
        /* 求出凸包的上半部分 */
        for (int i = n - 2; i >= 0; i--) {
            if (!used[i]) {
                while (hull.size() > m && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                    used[hull.get(hull.size() - 1)] = false;
                    hull.remove(hull.size() - 1);
                }
                used[i] = true;
                hull.add(i);
            }
        }
        /* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */
        hull.remove(hull.size() - 1);
        int size = hull.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[hull.get(i)];
        }
        return res;
    }


}
