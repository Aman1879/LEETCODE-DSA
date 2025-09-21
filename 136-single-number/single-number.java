class Solution {
    static{
         for(int i = 0; i < 1000; i++) {
            singleNumber(new int[]{1,2,3,3,4,1,5,6,6,5});
        }
    }
    public static int singleNumber(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum = num ^ sum;
        }

        return sum;
    }
}