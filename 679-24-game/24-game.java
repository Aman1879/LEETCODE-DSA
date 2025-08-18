class Solution {
    private static final double EPS = 1e-6;

    public boolean judgePoint24(int[] cards) {
        double[] nums = new double[cards.length];
        for (int i = 0; i < cards.length; i++) {
            nums[i] = (double) cards[i];
        }
        return backtrack(nums);
    }

    private boolean backtrack(double[] nums) {
        int n = nums.length;
        // Base case: only one number left
        if (n == 1) {
            return Math.abs(nums[0] - 24.0) < EPS;
        }

        // Try every pair (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // Build array of remaining numbers (excluding i, j)
                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next[idx++] = nums[k];
                    }
                }

                // Try all possible results of nums[i] and nums[j]
                for (double val : compute(nums[i], nums[j])) {
                    next[n - 2] = val;  // add new result as last element
                    if (backtrack(next)) return true;
                }
            }
        }
        return false;
    }

    // Compute all possible results of a and b
    private double[] compute(double a, double b) {
        return new double[] {
            a + b,
            a - b,
            b - a,
            a * b,
            (Math.abs(b) < EPS) ? Double.NaN : a / b,
            (Math.abs(a) < EPS) ? Double.NaN : b / a
        };
    }
}
