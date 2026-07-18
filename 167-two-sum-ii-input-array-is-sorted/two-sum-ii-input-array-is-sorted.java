class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int l = 0, r = n-1;
        int sum = 0;

        while(l<=r){
            sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            }else if(sum < target){
                l++;
            }else{
                break;
            }

        }
        int arr[] = new int[2];
        arr[0] = l + 1;
        arr[1] = r + 1;

        return arr;


    }
}