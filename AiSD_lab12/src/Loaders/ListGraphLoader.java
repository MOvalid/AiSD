package Loaders;

import Digraphs.AdjacencyListWeightedDigraph;
import Exceptions.MalformedGraphDescriptionException;

public class ListGraphLoader extends Loader {

    public static AdjacencyListWeightedDigraph loadDirectedGraph(String path) throws MalformedGraphDescriptionException {
        return  (AdjacencyListWeightedDigraph) loadDigraph(path, "(optional) u  2 x non-negative integers  1 x double", "\\s*(u{0,1})\\s*(\\d+)\\s+(\\d+)\\s+(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*", true, 2);
    }

    public static AdjacencyListWeightedDigraph loadUndirectedGraph(String path) throws MalformedGraphDescriptionException {
        return  (AdjacencyListWeightedDigraph) loadDigraph(path, " u  2 x non-negative integers  1 x double", "\\s*(u{1})\\s+(\\d+)\\s+(\\d+)\\s+(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*", false, 2);
    }

}
