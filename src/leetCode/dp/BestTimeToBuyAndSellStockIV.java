package leetCode.dp;

import java.util.Arrays;

/**
 * @author liyu
 * date 2020/12/28 8:56
 * description 买卖股票的最佳时机 IV
 * 给定一个整数数组?prices ，它的第 i 个元素?prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1：
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * 提示：
 * 0 <= k <= 10^9
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * 方法一：动态规划
     * 思路与算法
     * 与其余的股票问题类似，我们使用一系列变量存储「买入」的状态，再用一系列变量存储「卖出」的状态，通过动态规划的方法即可解决本题。
     * 我们用 buy[i][j] 表示对于数组 prices[0..i] 中的价格而言，进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润；
     * 用 sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。
     * 那么我们可以对状态转移方程进行推导。对于 buy[i][j]，我们考虑当前手上持有的股票是否是在第 i 天买入的。
     * 如果是第 i 天买入的，那么在第 i-1天时，我们手上不持有股票，对应状态 sell[i?1][j]，并且需要扣除 prices[i] 的买入花费；
     * 如果不是第 i 天买入的，那么在第i?1 天时，我们手上持有股票，对应状态 buy[i][j]。那么我们可以得到状态转移方程：
     * buy[i][j]=max{buy[i?1][j],sell[i?1][j]?price[i]}
     * 同理对于 sell[i][j]，如果是第 i 天卖出的，那么在第 i?1 天时，我们手上持有股票，对应状态 buy[i?1][j?1]，并且需要增加 prices[i] 的卖出收益；
     * 如果不是第 i 天卖出的，那么在第 i-1 天时，我们手上不持有股票，对应状态 \textit{sell}[i-1][j]sell[i?1][j]。那么我们可以得到状态转移方程：
     * sell[i][j]=max{sell[i?1][j],buy[i?1][j?1]+price[i]}
     * 由于在所有的 n 天结束后，手上不持有股票对应的最大利润一定是严格由于手上持有股票对应的最大利润的，
     * 然而完成的交易数并不是越多越好（例如数组 prices 单调递减，我们不进行任何交易才是最优的），因此最终的答案即为 sell[n?1][0..k] 中的最大值。
     * 细节
     * 在上述的状态转移方程中，确定边界条件是非常重要的步骤。我们可以考虑将所有的 buy[0][0..k] 以及 sell[0][0..k] 设置为边界。
     * 对于 buy[0][0..k]，由于只有 prices[0] 唯一的股价，因此我们不可能进行过任何交易，那么我们可以将所有的 buy[0][1..k] 设置为一个非常小的值，表示不合法的状态。
     * 而对于 buy[0][0]，它的值为 -prices[0]，即「我们在第 0 天以 prices[0] 的价格买入股票」是唯一满足手上持有股票的方法。
     * 对于sell[0][0..k]，同理我们可以将所有的 sell[0][1..k] 设置为一个非常小的值，表示不合法的状态。而对于 sell[0][0]，它的值为 0，即「我们在第 0 天不做任何事」是唯一满足手上不持有股票的方法。
     * 在设置完边界之后，我们就可以使用二重循环，在 i∈[1,n),j∈[0,k] 的范围内进行状态转移。
     * 需要注意的是，sell[i][j] 的状态转移方程中包含buy[i?1][j?1]，在 j=0 j=0 时其表示不合法的状态，因此在 j=0 时，我们无需对 sell[i][j] 进行转移，让其保持值为 0 即可。
     * 最后需要注意的是，本题中 k 的最大值可以达到 10^9，然而这是毫无意义的，因为 n 天最多只能进行
     * [n/2]笔交易，其中 []表示对 xx 向下取整。因此我们可以将 k 对 取较小值之后再进行动态规划。
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }

    /**
     * 注意到在状态转移方程中，buy[i][j] 和 sell[i][j] 都从buy[i?1][..] 以及 sell[i?1][..] 转移而来，因此我们可以使用一维数组而不是二维数组进行状态转移，即：
     * b[j]←max{b[j],s[j]?price[i]}
     * s[j]←max{s[j],b[j?1]+price[i]}
     * 这样的状态转移方程会因为状态的覆盖而变得不同。例如如果我们先计算 b 而后计算 s，
     * 那么在计算到 s[j] 时，其状态转移方程中包含的 b[j-1]b[j?1] 这一项的值已经被覆盖了，
     * 即本来应当是从二维表示中的 buy[i?1][j?1] 转移而来，而现在却变成了 buy[i][j?1]。
     * 但其仍然是正确的。我们考虑 buy[i][j?1] 的状态转移方程：
     * b[j?1]←buy[i][j?1]=max{buy[i?1][j?1],sell[i?1][j?1]?price[i]}
     * 那么 s[j]的状态转移方程实际上为：
     * s[j]←max{s[j],buy[i?1][j?1]+prices[i],sell[i?1][j?1]}
     * 根据 buy[i?1][j?1] 的状态转移方程，buy[i?1][j?1]≥sell[i?1][j?1]?prices[i]，因此有：
     * buy[i?1][j?1]+prices[i]≥sell[i?1][j?1]
     * 那么 sell[i?1][j?1] 这一项在 s[j] 的状态转移方程中不起任何作用，因此即使b[j?1] 被覆盖了，状态转移方程本质上仍然是正确的。
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
