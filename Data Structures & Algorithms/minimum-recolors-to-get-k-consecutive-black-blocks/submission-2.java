class Solution {
    public int minimumRecolors(String s, int k) {
        int n=s.length();
        int ans=0;
        int temp=0;
        int lo=0;
        int res=Integer.MAX_VALUE;

        for(int hi=0;hi<n;hi++){
            char ch = s.charAt(hi);
            if(ch=='W'){
                ans++;
            }
            temp++;
            while(temp>k && lo<=hi){
                if(s.charAt(lo)=='W')ans--;
                lo++;
                temp--;
            }
            if(temp==k){
                res=Math.min(res,ans);
            }
        }
        return res;
    }
}