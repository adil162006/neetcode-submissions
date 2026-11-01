class Solution {
    int[]dp;
    int n;
 int solve(int[] nums, int tar) {
    if (tar == 0) return 1;
    if (tar < 0) return 0;
    if(dp[tar]!=-1)return dp[tar];
    int ways = 0;

    for (int num : nums) {
        ways += solve(nums, tar - num);
    }

     return dp[tar] = ways;
}
    public int combinationSum4(int[] nums, int tar) {
        n = nums.length;
        dp = new int[tar + 1];
        Arrays.fill(dp, -1);
        int ans =0;

        
        return solve(nums,tar);

    }
}