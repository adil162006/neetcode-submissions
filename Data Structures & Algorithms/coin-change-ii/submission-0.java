class Solution {

    int [][]t;
    int solve(int idx,int[]a,int tar){
        if(tar==0)return 1;
        if(idx==0)return 0;

        if(t[idx][tar]!=-1)return t[idx][tar];
        int take = 0;
        if(a[idx-1]<=tar){
            take = solve(idx,a,tar-a[idx-1]);

        }
        int skip = solve(idx-1,a,tar);

        return t[idx][tar] = take+skip;
    }

    public int change(int tar, int[] a) {
        int n = a.length;
        if(tar==0)return 1;
        t=new int[n+1][tar+1];
         for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1);
        }
        return  solve(n,a,tar);

    }
}
