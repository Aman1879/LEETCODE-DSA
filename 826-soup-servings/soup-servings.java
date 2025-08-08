class Solution {
    private double[][] memo;

    public double soupServings(int n) {
        if (n > 5000) return 1.0;

        int scaledN = (int) Math.ceil(n / 25.0);
        memo = new double[scaledN + 1][scaledN + 1];

        // Initialize memo with -1 to mark unvisited
        for (int i = 0; i <= scaledN; i++) {
            for (int j = 0; j <= scaledN; j++) {
                memo[i][j] = -1.0;
            }
        }

        return dfs(scaledN, scaledN);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        if (memo[a][b] != -1.0) return memo[a][b];

        memo[a][b] = 0.25 * (
            dfs(Math.max(0, a - 4), b) +
            dfs(Math.max(0, a - 3), Math.max(0, b - 1)) +
            dfs(Math.max(0, a - 2), Math.max(0, b - 2)) +
            dfs(Math.max(0, a - 1), Math.max(0, b - 3))
        );

        return memo[a][b];
    }
}
