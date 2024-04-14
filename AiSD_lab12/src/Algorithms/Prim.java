package Algorithms;

import Digraphs.IWeightedDigraph;
import Digraphs.Vertex;
import Digraphs.WeightedEdge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prim extends MinimalTreeAlgorithm {

    public static List<WeightedEdge> getMinimalTreeWithoutSort(IWeightedDigraph iWeightedDigraph) {
        if(iWeightedDigraph == null){
            throw new IllegalArgumentException();
        }
        return minimalTree(iWeightedDigraph,-1,1);
    }

    public static List<WeightedEdge> getMinimalTreeWithoutSort(IWeightedDigraph iWeightedDigraph, int v){
        if(iWeightedDigraph == null || v < 0 || v >= iWeightedDigraph.getN()){
            throw new IllegalArgumentException();
        }
        return minimalTree(iWeightedDigraph, v,2);
    }

    public static List<WeightedEdge> getMinimalTreeWithSort(IWeightedDigraph iWeightedDigraph) {
        if(iWeightedDigraph == null){
            throw new IllegalArgumentException();
        }
        return minimalTreeWithSort(iWeightedDigraph,-1,1);
    }

    public static List<WeightedEdge> getMinimalTreeWithSort(IWeightedDigraph iWeightedDigraph, int v){
        if(iWeightedDigraph == null || v < 0 || v >= iWeightedDigraph.getN()){
            throw new IllegalArgumentException();
        }
        return minimalTreeWithSort(iWeightedDigraph, v,2);
    }


    private static List<WeightedEdge> minimalTree(IWeightedDigraph iWeightedDigraph, int v, int choice){
        List<Vertex> vertices = getVertices(iWeightedDigraph.getN());
        List<WeightedEdge> minimalTree = new ArrayList<WeightedEdge>();
        WeightedEdge edge = null;
        double minWeight;
        List<WeightedEdge> edges = new ArrayList<>();
        switch (choice){
            case 1:
                edges.addAll(iWeightedDigraph.verticesConnectedTo(iWeightedDigraph.getMinEdge().beginning));
                break;
            case 2:
                edges.addAll(iWeightedDigraph.verticesConnectedTo(v));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        while (minimalTree.size() < iWeightedDigraph.getN() - 1 && !edges.isEmpty()) {
            minWeight = Double.POSITIVE_INFINITY;
            for(int i = 0; i < edges.size(); i++){
                if(edges.get(i).weight < minWeight){
                    edge = edges.get(i);
                    minWeight = edge.weight;
                }
            }
            edges.remove(edge);
            if (vertices.get(edge.beginning).getSet().isDisjoint(vertices.get(edge.end).getSet())) {
                minimalTree.add(edge);
                vertices.get(edge.beginning).getSet().union(vertices.get(edge.end).getSet());
                edges.addAll(iWeightedDigraph.verticesConnectedTo(edge.end));
            }
        }
        if (minimalTree.size() < iWeightedDigraph.getN() - 1) {
            throw new IllegalStateException("NA TYM GRAFIE NIE MOŻNA ZBUDOWAĆ MINIMALNEGO DRZEWA ROZPINAJĄCEGO!!!");
        }
        return minimalTree;
    }




    private static List<WeightedEdge> minimalTreeWithSort(IWeightedDigraph iWeightedDigraph, int v, int choice){
        List<Vertex> vertices = getVertices(iWeightedDigraph.getN());
        List<WeightedEdge> minimalTree = new ArrayList<WeightedEdge>();
        WeightedEdge edge;
        List<WeightedEdge> edges = new ArrayList<>();
        switch (choice){
            case 1:
                edges.addAll(iWeightedDigraph.verticesConnectedTo(iWeightedDigraph.getMinEdge().beginning));
                break;
            case 2:
                edges.addAll(iWeightedDigraph.verticesConnectedTo(v));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        boolean sort = true;
        while (minimalTree.size() < iWeightedDigraph.getN() - 1 && !edges.isEmpty()) {
            if(sort) {
                Collections.sort(edges);
            }
            edge = edges.remove(0);
            if (vertices.get(edge.beginning).getSet().isDisjoint(vertices.get(edge.end).getSet())) {
                minimalTree.add(edge);
                vertices.get(edge.beginning).getSet().union(vertices.get(edge.end).getSet());
                edges.addAll(iWeightedDigraph.verticesConnectedTo(edge.end));
                sort = true;
            } else {
                sort = false;
            }
        }
        if (minimalTree.size() < iWeightedDigraph.getN() - 1) {
            throw new IllegalStateException("NA TYM GRAFIE NIE MOŻNA ZBUDOWAĆ MINIMALNEGO DRZEWA ROZPINAJĄCEGO!!!");
        }
        return minimalTree;
    }




    public static List<WeightedEdge> getMinimalTree(IWeightedDigraph iWeightedDigraph){
        if(iWeightedDigraph.isUndirected()) {
            List<Vertex> vertices = getVertices(iWeightedDigraph.getN());
            List<WeightedEdge> edges = iWeightedDigraph.verticesConnectedTo(0);
            if (edges.isEmpty()) {
                throw new IllegalArgumentException();
            }
            List<WeightedEdge> minimalTree = new ArrayList<>();
            double[] weights = new double[iWeightedDigraph.getN()];
            WeightedEdge minEdge = null, actualEdge;
            Vertex zero = vertices.get(0);
            double minWeight;
            int minVertex = 1;
            weights[0] = 0;

            for (int j = 0; j < edges.size(); j++) {
                weights[edges.get(j).end] = edges.get(j).weight;
            }
            for (int j = 1; j < weights.length; j++) {
                if (weights[j] == 0) {
                    weights[j] = Double.POSITIVE_INFINITY;
                }
            }

            while (minimalTree.size() < iWeightedDigraph.getN() - 1) {
                minWeight = Double.POSITIVE_INFINITY;
                for (int i = 1; i < weights.length; i++) {
                    if (zero.getSet().isDisjoint(vertices.get(i).getSet()) && minWeight > weights[i]) {
                        minVertex = i;
                        minWeight = weights[i];
                    }
                }
                edges = iWeightedDigraph.verticesConnectedTo(minVertex);
                minWeight = Double.POSITIVE_INFINITY;
                for (int i = 0; i < edges.size(); i++) {
                    actualEdge = edges.get(i);
                    if (zero.getSet().isJoint(vertices.get(actualEdge.end).getSet()) && actualEdge.weight < minWeight) {
                        minEdge = actualEdge;
                        minWeight = actualEdge.weight;
                    }
                }
                minimalTree.add(minEdge);
                zero.getSet().union(vertices.get(minVertex).getSet());
                for (int i = 0; i < edges.size(); i++) {
                    actualEdge = edges.get(i);
                    if (zero.getSet().isDisjoint(vertices.get(actualEdge.end).getSet())) {
                        weights[actualEdge.end] = min(weights[actualEdge.end], actualEdge.weight);
                    }
                }
            }
            return minimalTree;
        } else {
            System.out.println("Ten graf nie jest nieskierowany");
            return null;
        }
    }

    private static double min(double first, double second){
        if(first <= second){
            return first;
        } else {
            return second;
        }
    }

}
