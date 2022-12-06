package leetCode.array.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liyu
 * date 2022/12/6 9:34
 * description 1805. �ַ����в�ͬ��������Ŀ
 * ����һ���ַ��� word �����ַ��������ֺ�СдӢ����ĸ��ɡ�
 * �����ÿո��滻ÿ���������ֵ��ַ������磬"a123bc34d8ef34" ������ " 123  34 8  34" ��ע�⣬ʣ�µ���Щ����Ϊ�����ڱ˴�������һ���ո��������"123"��"34"��"8" �� "34" ��
 * ���ض� word ����滻���γɵ� ��ͬ ��������Ŀ��
 * ֻ�е����������� ����ǰ���� ��ʮ���Ʊ�ʾ��ͬ�� ����Ϊ����������Ҳ��ͬ��
 * ʾ�� 1��
 * ���룺word = "a123bc34d8ef34"
 * �����3
 * ���ͣ���ͬ�������� "123"��"34" �� "8" ��ע�⣬"34" ֻ����һ�Ρ�
 * ʾ�� 2��
 * ���룺word = "leet1234code234"
 * �����2
 * ʾ�� 3��
 * ���룺word = "a1b01c001"
 * �����1
 * ���ͣ�"1"��"01" �� "001" ��Ϊͬһ��������ʮ���Ʊ�ʾ����Ϊ�ڱȽ�ʮ����ֵʱ�����ǰ����Ĵ��ڡ�
 * ��ʾ��
 * 1 <= word.length <= 1000
 * word �����ֺ�СдӢ����ĸ���
 */
public class NumberOfDifferentIntegersInAString {
    public static int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<String>();
        int length = word.length();
        int i = 0;
        int j = 0;

        while (true) {
            while (i < length && !Character.isDigit(word.charAt(i))) {
                i++;
            }
            if (i == length) {
                break;
            }
            j = i;
            while (j < length && Character.isDigit(word.charAt(j))) {
                j++;
            }
            while (word.charAt(i) == '0' && j - i > 1) {
                i++;
            }
            set.add(word.substring(i, j));
            i = j;
        }
        return set.size();
    }

    public static void main(String[] args) {

        System.out.println("numDifferentIntegers(\"\") = " + numDifferentIntegers("a123bc34d8ef34"));
    }
}
