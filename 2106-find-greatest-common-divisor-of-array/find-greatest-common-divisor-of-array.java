class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[n-1];

        return gcd(min, max);

    }

    public static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}
}