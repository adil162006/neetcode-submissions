class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        boolean[][] reach = new boolean[n][n];
        int[] indeg = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];

            adj.get(src).add(dest);
            indeg[dest]++;
        }

        for(int i = 0; i < n; i++){
            if(indeg[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neigh : adj.get(node)){

                reach[node][neigh] = true;

                // Propagate all prerequisites of node to neigh
                for(int i = 0; i < n; i++){
                    if(reach[i][node]){
                        reach[i][neigh] = true;
                    }
                }

                indeg[neigh]--;

                if(indeg[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for(int[] pair : queries){
            res.add(reach[pair[0]][pair[1]]);
        }

        return res;
    }
}