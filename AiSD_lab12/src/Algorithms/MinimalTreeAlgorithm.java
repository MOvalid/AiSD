package Algorithms;

import Digraphs.IWeightedDigraph;
import Digraphs.Vertex;
import Digraphs.WeightedEdge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class MinimalTreeAlgorithm {

    static List<WeightedEdge> getAndSort(IWeightedDigraph iWeightedDigraph){
        List<WeightedEdge> edges = iWeightedDigraph.allUndirectedVertices();
        Collections.sort(edges);
        return edges;
    }

    static List<Vertex> getVertices(int n){
        List<Vertex> vertices = new ArrayList<Vertex>(n);
        Vertex vertex;
        for(int i = 0; i < n; i++){
            vertex = new Vertex(i);
            vertex.getSet().makeSet();
            vertices.add(vertex);
        }
        return vertices;
    }


}
