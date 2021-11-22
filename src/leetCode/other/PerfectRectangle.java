package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liyu
 * date 2021/11/16 9:29
 * description ��������
 * ����һ������ rectangles ������ rectangles[i] = [xi, yi, ai, bi] ��ʾһ��������ƽ�еľ��Ρ�������ε����¶����� (xi, yi) �����϶����� (ai, bi) ��
 * ������о���һ��ȷ������ĳ�����������򷵻� true �����򣬷��� false ��
 * ���룺rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
 * �����true
 * ���ͣ�5 ������һ����Ծ�ȷ�ظ���һ����������
 * ���룺rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
 * �����false
 * ���ͣ���Ϊ�м����ཻ������Ȼ�γ��˾��Σ������Ǿ�ȷ���ǡ�
 * 1 <= rectangles.length <= 2 * 104
 * rectangles[i].length == 4
 * -105 <= xi, yi, ai, bi <= 105
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/perfect-rectangle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        long area = 0;
        int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
        Map<Point, Integer> cnt = new HashMap<Point, Integer>();
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            area += (long) (a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            Point point1 = new Point(x, y);
            Point point2 = new Point(x, b);
            Point point3 = new Point(a, y);
            Point point4 = new Point(a, b);

            cnt.put(point1, cnt.getOrDefault(point1, 0) + 1);
            cnt.put(point2, cnt.getOrDefault(point2, 0) + 1);
            cnt.put(point3, cnt.getOrDefault(point3, 0) + 1);
            cnt.put(point4, cnt.getOrDefault(point4, 0) + 1);
        }

        Point pointMinMin = new Point(minX, minY);
        Point pointMinMax = new Point(minX, maxY);
        Point pointMaxMin = new Point(maxX, minY);
        Point pointMaxMax = new Point(maxX, maxY);
        if (area != (long) (maxX - minX) * (maxY - minY) || cnt.getOrDefault(pointMinMin, 0) != 1 || cnt.getOrDefault(pointMinMax, 0) != 1 || cnt.getOrDefault(pointMaxMin, 0) != 1 || cnt.getOrDefault(pointMaxMax, 0) != 1) {
            return false;
        }

        cnt.remove(pointMinMin);
        cnt.remove(pointMinMax);
        cnt.remove(pointMaxMin);
        cnt.remove(pointMaxMax);

        for (Map.Entry<Point, Integer> entry : cnt.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }

}
