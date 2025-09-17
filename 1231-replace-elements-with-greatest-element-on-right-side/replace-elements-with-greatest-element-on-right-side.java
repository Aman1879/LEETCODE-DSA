class Solution {
    public int[] replaceElements(int[] arr) {
        int n= arr.length;
        int r[] = new int[n];
         r[n-1] = -1;
        int max=arr[n-1];
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,arr[i+1]);
            r[i]=max;
        }
       
        return r;
    }
}