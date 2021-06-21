package algorithm.stringmatch;

import java.util.Arrays;

/**
 * @author liyu
 * @date 2020/1/3 15:48
 * @description 精确字符串匹配算法 单模式匹配
 * BF RK RM KMP
 * 给定文本T 记为T[0..n-10]
 * 匹配模式P 记为P[0..m-10]
 */
public class SinglePattern {
    public static void main(String[] args) {
        String T = "bacbababacaca";
        String P = "ababaca";
        int i = bruteForceStringMath(T, P);
        int j = KMP(T, P);
        System.out.println("j = " + j);
        System.out.println("i = " + i);

//        String P = "abaabcac";
//        int[] ints = prefixTable(P);
//        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 蛮力法
     *
     * @param T
     * @param P
     * @return
     */
    public static int bruteForceStringMath(String T, String P) {
        if (T.length() - P.length() < 0) {
            return 0;
        }
        int n = T.length();
        int m = P.length();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            while (j < m && T.charAt(i + j) == P.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i;
            }

        }
        return -1;
    }

    /**
     * maxL
     * 构造KMP的前缀表
     */
    public static int[] prefixTable(String P) {
        int[] prefixTable = new int[P.length()];
        int i = 1, j = 0;
        prefixTable[0] = 0;
        while (i < P.length()) {
            if (P.charAt(i) == P.charAt(j)) {
                prefixTable[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = prefixTable[j - 1];

            } else {
                i++;
            }
        }
        return prefixTable;
    }

    /**
     * KMP算法
     *
     * @param T
     * @param P
     * @return
     */
    public static int KMP(String T, String P) {
        int n = T.length();
        int m = P.length();
        int i = 0, j = 0;
        int[] ints = prefixTable(P);
        while (i < n) {
            if (T.charAt(i) == P.charAt(j)) {
                if (j == m - 1) {
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            } else if (j > 0) {
                j = ints[j - 1];
            } else {
                i++;
            }
        }
        return -1;
    }

    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }

    /**
     * 构造nextL数组
     * 直接计算或者先计算出maxL后右移一位
     *
     * @param P
     * @return
     */
//    public static int[] nextTable(String P) {
//        int l = P.length();
//        int[] next = new int[l];
//        int i = 0;   // P 的下标
//        int j = -1;
//        next[0] = -1;
//
//        while (i < l) {
//            if (j == -1 || P.charAt(i) == P.charAt(j)) {
//                i++;
//                j++;
//                next[i] = j;
//            } else
//                j = next[j];
//        }
//        return next;
//    }

    private static final int SIZE = 256; // 全局变量或成员变量

    /**
     * 获取b串ascii值对应的位置
     *
     * @param b  模式串
     * @param m  模式串长度
     * @param bc
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // 计算b[i]的ASCII值
            bc[ascii] = i;
        }
    }

    /**
     * 基于坏字符规则的BM算法
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @return
     */
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); // 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j表示主串与模式串匹配的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i + j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int) a[i + j]];
            int y = 0;
            if (j < m - 1) { // 如果有好后缀的话33|字符串匹配基础（中）：如何实现文本编辑器中的查找功能？
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j表示坏字符对应的模式串中的字符下标; m表示模式串长度
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] + 1;
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r] == true) {
                return r;
            }
        }
        return m;
    }

    // b表示模式串， m表示长度， suffix， prefix数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) { // 与b[0, m-1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1; //j+1表示公共后缀子串在b[0, i]中的起始下标
            }
            if (j == -1) prefix[k] = true; //如果公共后缀子串也是模式串的前缀子串
        }
    }
}
