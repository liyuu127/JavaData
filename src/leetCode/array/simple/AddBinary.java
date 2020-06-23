package leetCode.array.simple;


import lombok.experimental.UtilityClass;

/**
 * @author liyu
 * @date 2020/6/23 8:40
 * @description 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字?1?和?0。
 * <p>
 * 示例?1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例?2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * ?
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：https://leetcode-cn.com/problems/add-binary
 */
@UtilityClass
public  class AddBinary {

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String s = addBinary(a, b);
        System.out.println("s = " + s);
    }
    public String addBinary(String a, String b) {

        StringBuffer buffer = new StringBuffer();
        int c = 0;
        int al = a.length(), bl = b.length();
        int i = 0;

        while (i < al || i < bl) {
            c += (i < al ? Integer.parseInt(String.valueOf(a.charAt(al-i-1))) : 0);
            c += (i < bl ? Integer.parseInt(String.valueOf(b.charAt(bl-i-1))) : 0);
            buffer.append(c % 2);
            c = c / 2;
            i++;
        }
        if(c>0){
            buffer.append(1);
        }
        return buffer.reverse().toString();
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

}