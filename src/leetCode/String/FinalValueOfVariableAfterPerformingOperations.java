package leetCode.String;

/**
 * @author liyu
 * date 2022/12/23 9:53
 * description 2011. ִ�в�����ı���ֵ
 * ����һ�ֽ�֧�� 4 �ֲ����� 1 ������ X �ı�����ԣ�
 * ++X �� X++ ʹ���� X ��ֵ �� 1
 * --X �� X-- ʹ���� X ��ֵ �� 1
 * �����X ��ֵ�� 0
 * ����һ���ַ������� operations �������ɲ�����ɵ�һ���б�����ִ�����в����� X �� ����ֵ ��
 * ʾ�� 1��
 * <p>
 * ���룺operations = ["--X","X++","X++"]
 * �����1
 * ���ͣ���������������ִ�У�
 * �����X = 0
 * --X��X �� 1 ��X =  0 - 1 = -1
 * X++��X �� 1 ��X = -1 + 1 =  0
 * X++��X �� 1 ��X =  0 + 1 =  1
 * ʾ�� 2��
 * <p>
 * ���룺operations = ["++X","++X","X++"]
 * �����3
 * ���ͣ���������������ִ�У�
 * �����X = 0
 * ++X��X �� 1 ��X = 0 + 1 = 1
 * ++X��X �� 1 ��X = 1 + 1 = 2
 * X++��X �� 1 ��X = 2 + 1 = 3
 * ʾ�� 3��
 * <p>
 * ���룺operations = ["X++","++X","--X","X--"]
 * �����0
 * ���ͣ���������������ִ�У�
 * �����X = 0
 * X++��X �� 1 ��X = 0 + 1 = 1
 * ++X��X �� 1 ��X = 1 + 1 = 2
 * --X��X �� 1 ��X = 2 - 1 = 1
 * X--��X �� 1 ��X = 1 - 1 = 0
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= operations.length <= 100
 * operations[i] ������ "++X"��"X++"��"--X" �� "X--"
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {

        int ans = 0;
        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                ans++;
            } else {
                ans--;
            }
        }
        return ans;
    }
}
