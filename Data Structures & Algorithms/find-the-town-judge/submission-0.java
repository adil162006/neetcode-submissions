class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int [] out = new int[n];
        int[] in =  new int[n];

        for(int[] edge : trust){
            int s = edge[0]-1;
            int d = edge[1]-1;
            out[s]++;
            in[d]++;

        }
        for(int i =0;i<n;i++){
            if(out[i]==0 && in[i]==n-1)return i+1;;
        }
        return -1;
    }
}