class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& edges, int src, int dest, int k) {
        vector<int>res(n,1e8);
        res[src]=0;
        for(int i=0;i<k+1;i++){
            vector<int>temp = res;
            for(int j=0;j<edges.size();j++){
                int s=edges[j][0];
                int d =edges[j][1];
                int wt = edges[j][2];
                if(res[s]!=1e8 and temp[d]>res[s]+wt){
                    temp[d]=res[s]+wt;
                }
            }
            res=temp;
        }
        if(res[dest]==1e8)return -1;
        return res[dest];
    }
};