class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];

            int diagonalSq = length * length + width * width; 
            int area = length * width;

            if (diagonalSq > maxDiagonal) {
                maxDiagonal = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonal && area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
