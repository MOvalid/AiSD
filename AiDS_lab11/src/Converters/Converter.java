package Converters;

import Digraphs.AdjacencyListWeightedDigraph;
import Digraphs.AdjacencyMatrixWeightedDigraph;
import Digraphs.IWeightedDigraph;

import java.util.List;

public class Converter {

    public IWeightedDigraph convert(IWeightedDigraph digraph){
        if(digraph == null){
            throw new IllegalArgumentException();
        }
        IWeightedDigraph newDigraph;
        if(digraph instanceof AdjacencyMatrixWeightedDigraph){
            newDigraph = new AdjacencyListWeightedDigraph(digraph.getN());
        } else {
            newDigraph = new AdjacencyMatrixWeightedDigraph(digraph.getN());
        }
        List<Integer> vertices;
        int j;
        for(int i = 0; i < digraph.getN(); i++){
            vertices = digraph.verticesConnectedTo(i);
            while(!vertices.isEmpty()){
                j = vertices.remove(0);
                newDigraph.addEdge(i,j,digraph.weight(i,j));
            }
        }
        return newDigraph;
    }
}
