class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] height = new int[n];
        int total = 0;
        
        for (int i = 0; i < m; i++) {
            // update histogram heights
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            
            // count submatrices ending at row i
            for (int j = 0; j < n; j++) {
                int minHeight = height[j];
                for (int k = j; k >= 0; k--) {
                    minHeight = Math.min(minHeight, height[k]);
                    if (minHeight == 0) break;
                    total += minHeight;
                }
            }
        }
        
        return total;
    }
}
