package leetCode.other;

import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * 统计最高分的节点数目
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1。
 * 同时给你一个下标从0开始的整数数组parents表示这棵树，其中parents[i]是节点 i的父节点。由于节点 0是根，所以parents[0] == -1。
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的分数。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除，
 * 剩余部分是若干个 非空子树，这个节点的 分数为所有这些子树 大小的乘积。
 * 请你返回有 最高得分 节点的 数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-nodes-with-the-highest-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@UtilityClass
public class count_nodes_with_the_highest_score {

    public static void main(String[] args) {
        int i = countHighestScoreNodes(new int[]{-1, 2, 0});
        System.out.println("i = " + i);
    }

    long maxScore = 0;
    int cnt = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < parents.length; i++) {
            int parent = parents[i];
            children[parent].add(i);
        }

        dfs(0);
        return cnt;
    }

    public int dfs(int node) {
        long score = 1;
        int size = 0;
        for (Integer child : children[node]) {
            int c = dfs(child) + 1;
            score *= c;
            size += c;
        }
        int u = n - size - 1;
        if(u!=0)
        score *= u;
        if (score > maxScore) {
            cnt = 1;
            maxScore = score;
        } else if (score == maxScore) {
            cnt++;
        }
        return size;
    }

}
