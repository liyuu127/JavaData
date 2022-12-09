package leetCode.other;

/**
 * @author liyu
 * date 2022/12/9 9:22
 * description 1780. �ж�һ�������Ƿ���Ա�ʾ�������ݵĺ�
 * ����һ������ n ���������Խ� n ��ʾ�����ɸ���ͬ��������֮�ͣ����㷵�� true �������뷵�� false ��
 * ����һ������ y ������������� x ���� y == 3x �����ǳ�������� y �������ݡ�
 * ʾ�� 1��
 * ���룺n = 12
 * �����true
 * ���ͣ�12 = 31 + 32
 * ʾ�� 2��
 * ���룺n = 91
 * �����true
 * ���ͣ�91 = 30 + 32 + 34
 * ʾ�� 3��
 * ���룺n = 21
 * �����false
 * ��ʾ��
 * 1 <= n <= 107
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {

        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
