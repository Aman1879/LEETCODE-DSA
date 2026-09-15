class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zero = 0;

        int maxlen = Integer.MIN_VALUE;

        int l=0, r=0;

        while(r<n){

            if(nums[r] == 0){
                zero++;
            }

            while(zero > k){
                if(nums[l] == 0){
                    zero--;    
                }

                l++;
            }

            maxlen =  Math.max(r-l+1, maxlen);
            r++;
            
        }
        return maxlen;
    }
}