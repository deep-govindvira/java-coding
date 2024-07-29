package org.example.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Boolean> isVisited;
    List<List<Integer>> adjecancyList;

    Graph(Integer n) {
        isVisited = new ArrayList<>();
        adjecancyList = new ArrayList<> ();
        for(int i = 0; i < n; i++) {
            isVisited.add(false);
            adjecancyList.add(new ArrayList<>());
        }
    }

    void addEdge(Integer from, Integer to) {
        adjecancyList.get(from).add(to);
        adjecancyList.get(to).add(from);
    }
    
    void dfs(Integer node) {
        System.out.print(node + " ");
        isVisited.set(node, true);
        for(Integer adjNode : adjecancyList.get(node)) {
            if(!isVisited.get(adjNode)) {
                dfs(adjNode);
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        Graph graph = new Graph(n);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.dfs(0);
        for(int node = 0; node < n; node++) {
            if(!graph.isVisited.get(node)) {
                System.out.println();
                graph.dfs(node);
            }
        }
    }
}
