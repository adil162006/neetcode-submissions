class Solution {
    int[][]dp;

    int solve(int i,int j,String s,String t){
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];


        int skip = solve(i+1,j,s,t);

        int take =0;
        if(s.charAt(i)==t.charAt(j)){
            take = solve(i+1,j+1,s,t);

        }
        return dp[i][j] = skip+take;

    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n+1][m+1];
        for(int[] row : dp)Arrays.fill(row,-1);

        return solve(0,0,s,t);

    }
}