class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum +=  nums[i];
        }

        int target = sum - x;
        if (target < 0) return -1;
        if (target == 0) return nums.length;

        int currsum = 0;
        int maxlen = -1;
        int i=0, j=0;
        

        while(j < nums.length){

            currsum += nums[j];

            while(currsum  > target && i <= j){
                currsum -= nums[i];
                i++;
            }

            if(currsum == target) {
                maxlen = Math.max(maxlen, j-i+1);
            }

            j++;
           
        }

        if(maxlen == -1){
            return -1;
        }


         return nums.length - maxlen;
        

        
    }
}