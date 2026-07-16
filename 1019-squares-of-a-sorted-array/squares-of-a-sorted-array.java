class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++){
            int sq = arr[i] ;
            arr[i] = sq*sq;
        }

        Arrays.sort(arr);

        return arr;
    }
}