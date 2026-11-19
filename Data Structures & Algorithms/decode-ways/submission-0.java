class Solution {
    int[]t;
    int n;
    int solve(int i,String s){
        if(i==n)return 1;
        if(i>n)return 0;
        if(s.charAt(i)=='0')return 0;
        if(t[i]!=-1)return t[i];
        int skip = solve(i+1,s);
        int take=0;
        if(i<n-1 ){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10 && num<=26)take = solve(i + 2, s);
        }
        return t[i] = skip+take;
            

    }
    public int numDecodings(String s) {
        n=s.length();
        t=new int[n+1];
        Arrays.fill(t,-1);
        return solve(0,s);
    }
}