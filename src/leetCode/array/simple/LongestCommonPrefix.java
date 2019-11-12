package leetCode.array.simple;

/**
 * @author liyu
 * @date 2019/11/12 17:16
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
        String[] strs2={"dog","racecar","car"};
        System.out.println("longestCommonPrefix(strs2) = " + longestCommonPrefix(strs2));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String result=strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result)!=0){
                result=result.substring(0,result.length()-1);
                if (result.length()==0){
                    return "";
                }
            }
        }
        return result;

    }
}
