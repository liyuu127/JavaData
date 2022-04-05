package leetCode.other;

/**
 * @author liyu
 * date 2022/2/25 9:01
 * description Complex Number Multiplication
 * A complex number can be represented as a string on the form "real+imaginaryi" where:
 * real is the real part and is an integer in the range [-100, 100].
 * imaginary is the imaginary part and is an integer in the range [-100, 100].
 * i2 == -1.
 * Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
 * Example 1:
 * Input: num1 = "1+1i", num2 = "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: num1 = "1+-1i", num2 = "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Constraints:
 * num1 and num2 are valid complex numbers.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class complex_number_multiplication {
    public static void main(String[] args) {
        String s = complexNumberMultiply("1+-1i", "0+0i");
        System.out.println("s = " + s);
    }
    public static String complexNumberMultiply(String num1, String num2) {

        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        int a = Integer.parseInt(split1[0]);
        int c = Integer.parseInt(split2[0]);
        int b = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1));
        int d = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));

        int real = a * c - b * d;
        int imaginary = a * d + c * b;
        return real + "+" + imaginary + "i";
    }
}
