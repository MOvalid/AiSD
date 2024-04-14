package Algorithms;

import Digraphs.IWeightedDigraph;
import Digraphs.WeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prim1 extends MinimalTreeAlgorithm{

    public static List<WeightedEdge> prim(IWeightedDigraph iWeightedDigraph){
        PriorityQueue<WeightedEdge> queue = new PriorityQueue<>();
        List<WeightedEdge> minimalTree = new ArrayList<>();
        int vertex;
        boolean[] isInMST = new boolean[iWeightedDigraph.getN()];
        List<WeightedEdge> edges = iWeightedDigraph.verticesConnectedTo(0);
        WeightedEdge actualEdge;
        for(int i = 0; i < edges.size(); i++){
            queue.offer(edges.get(i));
        }
        isInMST[0] = true;
        while(!queue.isEmpty() && minimalTree.size() < iWeightedDigraph.getN()-1){
            actualEdge = queue.poll();
            vertex = actualEdge.end;

            if(isInMST[vertex]){
                continue;
            }
            isInMST[vertex] = true;
            minimalTree.add(actualEdge);
            edges = iWeightedDigraph.verticesConnectedTo(vertex);
            for(int i = 0; i < edges.size(); i++){
                queue.offer(edges.get(i));
            }
        }
        return minimalTree;
    }
}
