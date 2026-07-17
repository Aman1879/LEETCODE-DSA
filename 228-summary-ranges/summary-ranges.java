class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> st = new ArrayList<>();

        if(n == 0) return st;

        int i = 0;

        while(i < n){

            int l = nums[i];
             int r= l;

            while(i+1 < n && nums[i + 1] == nums[i] + 1){

                i++;
                r = nums[i];
            }

            if(l == r){
                st.add(l + "");
            }else {
            st.add(l + "->" + r);
            }
            i++;
        }

        return st;

        
    }
}