package leetCode.fs.hard;

import java.util.*;

/**
 * @author liyu
 * date 2021/11/9 9:27
 * description ������Ϸ
 * �����ڲ���������Ϸ��һ�����֡�
 * �����������Ϸ�����У��������� һ�� ����ÿ�������ɫ�����ǣ���ɫ 'R'����ɫ 'Y'����ɫ 'B'����ɫ 'G' ���ɫ 'W' ���������Ҳ��һЩ����
 * ���Ŀ���� ��� ���������е���ÿһ�غϣ�
 * �������ϵĲ�����ѡ�� ����һ�� ��Ȼ���������������һ�����У�����֮�����һ�������һ�ˡ�
 * ���ţ�����г��� ���������������� �� ��ɫ��ͬ ���������Ļ����Ͱ������Ƴ�����
 * ��������Ƴ�����ͬ�����³�����������������������ɫ��ͬ��������������Լ����Ƴ���Щ��ֱ�����������Ƴ�������
 * ��������������򶼱��Ƴ�������Ϊ��Ӯ�ñ�����Ϸ��
 * �ظ�������̣�ֱ����Ӯ����Ϸ��������û�и������
 * ����һ���ַ��� board ����ʾ�������ʼ�������������һ���ַ��� hand ����ʾ����Ĳ���
 * ���㰴�������������Ƴ������������򣬼��㲢��������� ���� ��������������Ƴ��������е��򣬷��� -1 ��
 * <p>
 * ���룺board = "WRRBBW", hand = "RB"
 * �����-1
 * ���ͣ��޷��Ƴ������ϵ������򡣿��Եõ�����þ����ǣ�
 * - ����һ�� 'R' ��ʹ�����Ϊ WRRRBBW ��WRRRBBW -> WBBW
 * - ����һ�� 'B' ��ʹ�����Ϊ WBBBW ��WBBBW -> WW
 * �����ϻ�ʣ����û����������Բ��롣
 * <p>
 * ���룺board = "WWRRBBWW", hand = "WRBRW"
 * �����2
 * ���ͣ�Ҫ����������ϵ��򣬿��԰��������裺
 * - ����һ�� 'R' ��ʹ�����Ϊ WWRRRBBWW ��WWRRRBBWW -> WWBBWW
 * - ����һ�� 'B' ��ʹ�����Ϊ WWBBBWW ��WWBBBWW -> WWWW -> empty
 * ֻ������г� 2 ����Ϳ���������档
 * <p>
 * ���룺board = "RBYYBBRRB", hand = "YRBGB"
 * �����3
 * ���ͣ�Ҫ����������ϵ��򣬿��԰��������裺
 * - ����һ�� 'Y' ��ʹ�����Ϊ RBYYYBBRRB ��RBYYYBBRRB -> RBBBRRB -> RRRB -> B
 * - ����һ�� 'B' ��ʹ�����Ϊ BB ��
 * - ����һ�� 'B' ��ʹ�����Ϊ BBB ��BBB -> empty
 * ֻ������г� 3 ����Ϳ���������档
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/zuma-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ZumaGame {

    public int findMinStep(String board, String hand) {
        char[] arr = hand.toCharArray();
        Arrays.sort(arr);
        hand = new String(arr);

        // ��ʼ���ö���ά����״̬���У����е�����Ԫ�طֱ�Ϊ������״̬��������״̬�ͻغ���
        Queue<State> queue = new ArrayDeque<State>();
        queue.offer(new State(board, hand, 0));

        // ��ʼ���ù�ϣ����ά�����ѷ��ʹ���״̬
        Set<String> visited = new HashSet<String>();
        visited.add(board + "#" + hand);

        while (!queue.isEmpty()) {
            State state = queue.poll();
            String curBoard = state.board;
            String curHand = state.hand;
            int step = state.step;
            for (int i = 0; i <= curBoard.length(); ++i) {
                for (int j = 0; j < curHand.length(); ++j) {
                    // �� 1 ����֦����: ��ǰ�����ɫ����һ�������ɫ��ͬ
                    if (j > 0 && curHand.charAt(j) == curHand.charAt(j - 1)) {
                        continue;
                    }

                    // �� 2 ����֦����: ֻ��������ͬ��ɫ����Ŀ�ͷλ�ò�������
                    //���������ɫ�Ͳ���������ɫ��ͬ ����
                    if (i > 0 && curBoard.charAt(i - 1) == curHand.charAt(j)) {
                        continue;
                    }

                    // �� 3 ����֦����: ֻ���������������������
                    boolean choose = false;
                    //  - �� 1 ����� : ��ǰ����ɫ�����������ɫ��ͬ
                    if (i < curBoard.length() && curBoard.charAt(i) == curHand.charAt(j)) {
                        choose = true;
                    }
                    //  - �� 2 ����� : ��ǰ����ɫ��ͬ���뵱ǰ��ɫ��ͬʱ�������
                    if (i > 0 && i < curBoard.length() && curBoard.charAt(i - 1) == curBoard.charAt(i) && curBoard.charAt(i - 1) != curHand.charAt(j)) {
                        choose = true;
                    }

                    if (choose) {
                        String newBoard = clean(curBoard.substring(0, i) + curHand.charAt(j) + curBoard.substring(i));
                        String newHand = curHand.substring(0, j) + curHand.substring(j + 1);
                        if (newBoard.length() == 0) {
                            return step + 1;
                        }
                        String str = newBoard + "#" + newHand;
                        if (visited.add(str)) {
                            queue.offer(new State(newBoard, newHand, step + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public String clean(String s) {
        String prev = "";
        while (!s.equals(prev)) {
            StringBuffer sb = new StringBuffer();
            int consecutive = 1;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (i > 0) {
                    if (c == s.charAt(i - 1)) {
                        ++consecutive;
                    } else {
                        if (consecutive >= 3) {
                            sb.delete(sb.length() - consecutive, sb.length());
                        }
                        consecutive = 1;
                    }
                }
                sb.append(c);
            }
            if (consecutive >= 3) {
                sb.delete(sb.length() - consecutive, sb.length());
            }
            prev = s;
            s = sb.toString();
        }
        return s;
    }

    class State {
        String board;
        String hand;
        int step;

        public State(String board, String hand, int step) {
            this.board = board;
            this.hand = hand;
            this.step = step;
        }


    }
}

