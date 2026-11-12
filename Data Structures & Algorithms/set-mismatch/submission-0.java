class Solution {
    public int[] findErrorNums(int[] a) {
        int n = a.length;
        int sum = n*(n+1)/2;
        int arrSum=0;
        int dup=0;

        HashSet<Integer>set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(set.contains(a[i])){
                dup = a[i];
                continue;
            }
            arrSum +=a[i];
            set.add(a[i]);
        }
        int missing = sum - arrSum;
        return new int[]{dup,missing};


    }
}