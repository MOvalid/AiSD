package Algorithms;

import Digraphs.IWeightedDigraph;
import Digraphs.Vertex;
import Digraphs.WeightedEdge;

import java.util.ArrayList;
import java.util.List;

public class Kruskal extends MinimalTreeAlgorithm {

    public static List<WeightedEdge> getMinimalTree(IWeightedDigraph iWeightedDigraph){
        if(iWeightedDigraph == null){
            throw new IllegalArgumentException();
        }
        if(iWeightedDigraph.isUndirected()) {
            List<WeightedEdge> edges = getAndSort(iWeightedDigraph);
            List<Vertex> vertices = getVertices(iWeightedDigraph.getN());
            List<WeightedEdge> minimalTree = new ArrayList<WeightedEdge>();
            WeightedEdge edge;

            for (int i = 0; i < edges.size() && minimalTree.size() < iWeightedDigraph.getN() - 1; i++) {
                edge = edges.get(i);
                if (vertices.get(edge.beginning).getSet().isDisjoint(vertices.get(edge.end).getSet())) {
                    minimalTree.add(edge);
                    vertices.get(edge.beginning).getSet().union(vertices.get(edge.end).getSet());
                }
            }
            if (minimalTree.size() < iWeightedDigraph.getN() - 1) {
                throw new IllegalStateException("NA TYM GRAFIE NIE MOŻNA ZBUDOWAĆ MINIMALNEGO DRZEWA ROZPINAJĄCEGO!!!");
            }

            return minimalTree;
        } else {
            System.out.println("Ten graf nie jest nieskierowany");
            return null;
        }
    }
}
