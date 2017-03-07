package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sgupta on 11/11/16.
 */
public class DFS {
    int V;
    List<List<Integer>> adj;
    public DFS(int v) {
        this.V = v;
        adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    void DFSUtil(int i, Boolean [] visited) {
        if(!visited[i]) {
            visited[i] = true;
            for(int j : adj.get(i)) {
                if(!visited[j])
                    DFSUtil(j, visited);
            }
        }
    }

    public void DFS() {
        Boolean [] visited = new Boolean[V];
        for(int i=0;i<V;i++)
            visited[i] = false;
        for(int i=0;i<V;i++) {
            DFSUtil(i, visited);
        }
    }
}
