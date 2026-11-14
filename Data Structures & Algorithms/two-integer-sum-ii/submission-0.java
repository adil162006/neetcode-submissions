class Solution {
    public int[] twoSum(int[] a, int tar) {
        int n = a.length;
        int lo=0;
        int hi=n-1;

        while(lo<=hi){
            if(a[lo]+a[hi]<tar){
                lo++;
           }else if(a[lo]+a[hi]>tar){
            hi--;
           }else if(a[lo]+a[hi] == tar){
            return new int[]{lo+1,hi+1};
           }
        }
        return new int[]{-1,-1};
    }
}
