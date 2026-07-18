class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;

        int idx = 0;

        while(r < n){
            int count = 0;
            while( r < n && nums[l] == nums[r]){
                count++;
                if(count <= 2){
                    nums[idx++] = nums[r];
                }
                r++;
            }
            l = r;
        }
    

        return idx;

    }
}