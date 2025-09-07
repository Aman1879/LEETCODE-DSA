class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int ind = 0;

        for(int i=1; i<=n/2; i++){
            res[ind] = i;
            ind++;
            res[ind] = -i;
           ind++;

        }

        if(n%2 != 0){
            res[ind] = 0;
        }

        return res;
    }
}