package leetCode.String;

import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * date 2022/1/10 9:24
 * description
 */
@UtilityClass
public class additive_number {

    public static void main(String[] args) {
        boolean additiveNumber = isAdditiveNumber("101");
        System.out.println("additiveNumber = " + additiveNumber);
    }

    public boolean isAdditiveNumber(String num) {
        int length = num.length();
        if (length < 3) return false;

        for (int i = 1; i < length; i++) {
            if (num.charAt(0) == '0' && i != 1) break;
            for (int j = i; j < length; j++) {
                if (num.charAt(j) == '0' && j != i) ;
                if (valid(0, i - 1, j, num)) return true;
            }

        }
        return false;
    }


    public boolean valid(int firstS, int firstE, int secondE, String num) {
        if (firstE + 1 >= num.length() || secondE >= num.length()) return false;
        if ((num.charAt(firstS) == '0' && firstE - firstS > 0) || (num.charAt(firstE + 1) == '0' && secondE - firstE - 1 > 0))
            return false;
        String s = addTwoNumbers(firstS, firstE, firstE + 1, secondE, num);
        int length = s.length();
        if (secondE + length <= num.length() - 1) {
            if (s.equals(num.substring(secondE + 1, secondE + length + 1))) {
                if (secondE + length == num.length() - 1) return true;
                return valid(firstE + 1, secondE, secondE + length, num);
            }
        }
        return false;

    }

    public String addTwoNumbers(int firstS, int firstE, int secondS, int secondE, String num) {
        int c = 0;
        StringBuffer sb = new StringBuffer();
        while (firstE >= firstS || secondE >= secondS) {
            int a = 0;
            int b = 0;
            if (firstE >= firstS) {
                a = Integer.parseInt(num.charAt(firstE) + "");
                firstE--;
            }
            if (secondE >= secondS) {
                b = Integer.parseInt(num.charAt(secondE) + "");
                secondE--;
            }
            int v = (a + b + c) % 10;
            c = (a + b + c) / 10;
            sb.append(v);
        }
        if (c != 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
