
class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] res = new int[V];
        int[] indeg = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : prerequisites){
            int src = edge[1];
            int dest = edge[0];
            adj.get(src).add(dest);
            indeg[dest]++;
        }
        
        for(int i = 0; i < V; i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        
        int idx = 0; 
        
        
        while(!q.isEmpty()){
            int node = q.poll();
            res[idx++] = node; 
            
            for(int j = 0; j < adj.get(node).size(); j++){
                int neigh = adj.get(node).get(j);
                indeg[neigh]--;
                if(indeg[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }
        
        if(idx == V) {
            return res;
        } else {
            return new int[]{};
        }
    }
}