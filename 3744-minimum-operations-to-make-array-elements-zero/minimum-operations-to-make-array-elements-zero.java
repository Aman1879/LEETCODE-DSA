class Solution {
    public long minOperations(int[][] queries) {
        // Precompute powers of 4 up to >1e9
        long[] pow4 = new long[32];
        pow4[0] = 1;
        for (int i = 1; i < 32; i++) {
            pow4[i] = pow4[i - 1] * 4L;
            if (pow4[i] > (long)1e10) break;
        }

        long result = 0;

        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long totalSteps = 0;

            for (int k = 1; k < 32; k++) {
                long left = pow4[k - 1];
                long right = pow4[k] - 1;

                // overlap with [l, r]
                long start = Math.max(l, left);
                long end = Math.min(r, right);
                if (start > end) continue;

                long count = end - start + 1;
                totalSteps += count * k;
            }

            long ops = (totalSteps + 1) / 2; // ceil division
            result += ops;
        }

        return result;
    }
}
