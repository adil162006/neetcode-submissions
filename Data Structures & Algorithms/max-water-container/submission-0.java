class Solution {
    public int maxArea(int[] a) {
        int n= a.length;
        int lo=0;
        int hi=n-1;
        int maxWater = Integer.MIN_VALUE;

        while(lo<=hi){
            int hieght= Math.min(a[lo],a[hi]);
            int width = Math.abs(lo-hi);
            maxWater = Math.max(maxWater,hieght*width);
            if(a[lo]<a[hi])lo++;
            else hi--;
        }
        return maxWater;

    }
}