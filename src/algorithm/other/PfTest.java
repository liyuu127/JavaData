package algorithm.other;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liyu
 * @date 2020/6/28 11:22
 * @description
 */
public class PfTest {

    static class BitKeeper {

        private int maxbit;

        public void random() {
            long value = ThreadLocalRandom.current().nextLong(2L << 32);
            int bit = lowZeros(value);
            if (bit > this.maxbit) {
                this.maxbit = bit;
            }
        }

        private int lowZeros(long value) {
            int i = 0;
            for (; i < 32; i++) {
                if (value >> i << i != value) {
                    break;
                }
            }
            return i - 1;
        }
    }

    static class Experiment {

        private int n;
        private BitKeeper keeper;

        public Experiment(int n) {
            this.n = n;
            this.keeper = new BitKeeper();
        }

        public void work() {
            for (int i = 0; i < n; i++) {
                this.keeper.random();
            }
        }

        public void debug() {
            System.out.printf("%d %.2f %d\n", this.n, Math.log(this.n) / Math.log(2), this.keeper.maxbit);
        }
    }

    public static void main(String[] args) {
//        for (int i = 1000; i < 100000; i += 100) {
//            Experiment exp = new Experiment(i);
//            exp.work();
//            exp.debug();
//        }
        long m = ThreadLocalRandom.current().nextLong(2L << 32);


        System.out.println("2L = " + Long.toBinaryString(2L));
        System.out.println("1L << 32 = " + Long.toBinaryString(2L<<32));
        System.out.println("m = " + Long.toBinaryString(m));
    }
}
