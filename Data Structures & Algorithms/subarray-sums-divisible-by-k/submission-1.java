class Solution {
    public int subarraysDivByK(int[] a, int k) {
        HashMap<Integer,Integer>f=new HashMap<>();
        int res=0;
        int sum=0;
        f.put(0,1);
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            int rem = sum%k;

            int freq=f.getOrDefault(rem,0);
            res+=freq;
            f.put(rem,f.getOrDefault(rem,0)+1);
        }
        return res;
    }
}