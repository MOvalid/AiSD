package Loaders;

import Digraphs.AdjacencyMatrixWeightedDigraph;
import Exceptions.MalformedGraphDescriptionException;

public class MatrixGraphLoader extends Loader {

    public static AdjacencyMatrixWeightedDigraph loadDirectedGraph(String path) throws MalformedGraphDescriptionException {
        return (AdjacencyMatrixWeightedDigraph) loadDigraph(path, "(optional) u  2 x non-negative integers  1 x double", "\\s*(u{0,1})\\s*(\\d+)\\s+(\\d+)\\s+(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*", true, 1);
    }

    public static AdjacencyMatrixWeightedDigraph loadUndirectedGraph(String path) throws MalformedGraphDescriptionException {
        return (AdjacencyMatrixWeightedDigraph) loadDigraph(path, " u  2 x non-negative integers  1 x double", "\\s*(u{1})\\s+(\\d+)\\s+(\\d+)\\s+(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*", false, 1);
    }

}
