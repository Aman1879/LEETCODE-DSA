class Solution {
    public int bestClosingTime(String customers) {

        int p =0;

        for(char c : customers.toCharArray()){

            if(c == 'Y') p++;

        }

        int minp = p;

        int ans =0;

        for(int i=0; i<customers.length(); i++){
            if(customers.charAt(i) == 'Y'){
                p--;
            }else{
                p++;
            }
            if(p < minp) {

            minp = p;
            ans = i+1;

            }
        }

        return ans;
        
    }
}