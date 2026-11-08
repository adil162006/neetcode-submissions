class Solution {
    int [][] t;
    int solve(int n , int tar){
        if(tar==0 )return 0;
        if(n==0)return Integer.MAX_VALUE - 1;;

        int val = n*n;

        if(t[n][tar]!=-1) return t[n][tar];
        int take= Integer.MAX_VALUE - 1;
        if(val<=tar){
            take =  1 + solve(n,tar-val);
        }

        int skip = solve(n-1,tar);


        return t[n][tar]= Math.min(take,skip);
        
    }
    public int numSquares(int n) {
        int result = (int)Math.sqrt(n);
        t=new int[result+1][n+1];
        for(int i=0;i<=result;i++)Arrays.fill(t[i],-1);
        return solve(result,n);
    }
}