package data_structure.fenwick;

/**
 * Fenwick tree. (also known as: Binary index tree)
 *
 * @WARNING 1-indexed, [inclusive,inclusive].
 */
public class FenwickTree {
    long N;
    long[] data;

    public FenwickTree(int n) {
        N = n;
        data = new long[n+1];
    }

    public long sum(int i) {
        long s = 0;
        while (i > 0) {
            s += data[i];
            i -= i & (-i);
        }
        return s;
    }

    public long range(int i, int j) {
        return sum(j) - sum(i-1);
    }

    public void set(int i, long x) {
        add(i, x-range(i, i));
    }

    public void add(int i, long x) {
        while (i <= N) {
            data[i] += x;
            i += i & (-i);
        }
    }
}