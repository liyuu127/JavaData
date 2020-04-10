package leetCode.array.general;

/**
 * @author liyu
 * @date 2020/4/3 9:34
 * @description �ַ���ת��������
 * ������ʵ��һ��?atoi?������ʹ���ܽ��ַ���ת����������
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ����������ת���������£�
 * �����һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ�����������ַ�����������γ�һ���з���������
 * �����һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�һ��������
 * ���ַ�������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����ô��Щ�ַ����Ա����ԣ����ǶԺ�����Ӧ�����Ӱ�졣
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת�������޷�������Чת����
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0 ��
 * ��ʾ��
 * �����еĿհ��ַ�ֻ�����ո��ַ� ' ' ��
 * �������ǵĻ���ֻ�ܴ洢 32 λ��С���з�����������ô����ֵ��ΧΪ?[?231,? 231?? 1]�������ֵ���������Χ���뷵�� ?INT_MAX (231?? 1) ��?INT_MIN (?231) ��
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: "42"
 * ���: 42
 * ʾ��?2:
 * <p>
 * ����: "   -42"
 * ���: -42
 * ����: ��һ���ǿհ��ַ�Ϊ '-', ����һ�����š�
 * ?    ���Ǿ����ܽ���������������������ֵ�����������������õ� -42 ��
 * ʾ��?3:
 * <p>
 * ����: "4193 with words"
 * ���: 4193
 * ����: ת����ֹ������ '3' ����Ϊ������һ���ַ���Ϊ���֡�
 * ʾ��?4:
 * <p>
 * ����: "words and 987"
 * ���: 0
 * ����: ��һ���ǿ��ַ��� 'w', �����������ֻ��������š�
 * ����޷�ִ����Ч��ת����
 * ʾ��?5:
 * <p>
 * ����: "-91283472332"
 * ���: -2147483648
 * ����: ���� "-91283472332" ���� 32 λ�з���������Χ��
 * ?    ��˷��� INT_MIN (?231) ��
 */
public class StringToIntegerAtoi {

    public static void main(String[] args) {
//        String s = "20000000000000000000";
//        String s = "2147483648";
//        String s = "-2147483648";
//        String s = "2147483647";
//        String s = "-91283472332";
//        String s = "words and 987";
//        String s="4193 with words";
        String s = "-91283472332";
        int i = myAtoi(s);
        System.out.println("i = " + i);
    }

    public static int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length < 1) {
            return 0;
        }

        boolean flag = true;
        int start = 0;
        if (chars[0] == '+') {
            start++;
        } else if (chars[0] == '-') {
            start++;
            flag = false;
        } else if (!Character.isDigit(chars[0])) {
            return 0;
        }

        int value = 0;
        while (start < chars.length && Character.isDigit(chars[start])) {
            int dig = chars[start] - '0';
            if ((Integer.MAX_VALUE - dig) / 10 < value) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            value = value * 10 + dig;
            start++;
        }
        return flag ? value : -value;

    }

}