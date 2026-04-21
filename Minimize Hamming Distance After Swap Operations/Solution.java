class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }

    public void union(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) return;

        if(rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if(rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DisjointSet ds = new DisjointSet(n);
        for (int[] swap : allowedSwaps) {
            ds.union(swap[0], swap[1]);
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = ds.find(i); 
            map.putIfAbsent(p, new HashMap<>());
            map.get(p).put(source[i], map.get(p).getOrDefault(source[i], 0) + 1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int p = ds.find(i); 
            Map<Integer, Integer> freq = map.get(p);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                ans++;
            }
        }

        return ans;
    }
}
