class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b)->a.wt-b.wt);
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:times){
            int src = edge[0]-1;
            int dest = edge[1]-1;
            int wt = edge[2];

            adj.get(src).add(new Pair(dest,wt));
        }
        int[] res = new int[n];
        Arrays.fill(res,Integer.MAX_VALUE);
        k--;
        res[k] = 0;
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.wt;
            if(d>res[u]) continue;
            for(Pair neigh : adj.get(u)){
                int v = neigh.node;
                int wt = neigh.wt;
                if(res[u]+wt<res[v]){
                    res[v]= res[u]+wt;
                    pq.add(new Pair(v,res[v]));
                }
            }
        }
        int maxV = Integer.MIN_VALUE;
        for(int i =0;i<res.length;i++){
            maxV = Math.max(maxV,res[i]);
        }
        if(maxV == Integer.MAX_VALUE)return -1;
        else return maxV;
    }
}