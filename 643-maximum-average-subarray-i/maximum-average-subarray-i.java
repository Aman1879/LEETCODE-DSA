class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int l = 0, r=0;
        double sum= 0;
        double avg = 0;
        double maxavg = Integer.MIN_VALUE;
        while(r < nums.length){
            sum += nums[r];
            while(r-l+1 > k){
                sum -= nums[l];
                l++;

            }

            if(r-l+1 == k){
                avg = sum/k;
                maxavg = Math.max(avg,maxavg);
            }
            
            r++;
        }
        return maxavg;
    }
}