class Solution {
    public int numRescueBoats(int[] a, int limit) {
        int n=a.length;
        int lo=0;
        int hi=n-1;
        int ans =0;
        Arrays.sort(a);
        while(lo<=hi){
        
            int sum = a[hi];
            if(a[hi]==limit){
                hi--;
                ans++;
                continue;
            }else if(a[hi]<limit){
                sum+=a[lo];
                if(sum>limit){
                    hi--;
                    ans++;
                    continue;
                }else{
                    ans++;
                    lo++;
                    hi--;
                }
            }else{
                hi--;
            }
        }
        return ans;
    }
}