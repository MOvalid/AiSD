package Digraphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixWeightedDigraph implements IWeightedDigraph {

    private class Iterator<WeigthedEdge> implements java.util.Iterator<WeightedEdge> {
        private double[] actual;
        private final int v;
        private int i = 0;

        Iterator(double[] actual, int v){
            this.actual = actual;
            this.v = v;
        }

        public boolean hasNext(){
            if(i < n) {
                for (int j = i; j < actual.length; j++) {
                    if (actual[j] != 0) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        public WeightedEdge next(){
            int j;
            for(j = i; j < actual.length; j++){
                if(actual[j] != 0){
                   i = j + 1;
                   break;
                }
            }
            if(j < n) {
                return new WeightedEdge(v, j, weight(v, j));
            }
            return null;
        }
    }

    private double[][] matrix;
    private int n;

    public AdjacencyMatrixWeightedDigraph(int n){
        if(n < 0){
            throw new IllegalArgumentException("Rozmiar macierzy nie może być mniejszy od zera");
        }
        matrix = new double[n][n];
        this.n = n;
    }
    @Override
    public int edgeCount() {
        int edges = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] != 0){
                    edges++;
                }
            }
        }
        return edges;
    }

    @Override
    public int vertexCount() {
        int counter = 0;
        boolean[] vertices = new boolean[getN()];
        for(int i = 0; i < matrix.length && counter < n; i++){
            for(int j = 0; j < matrix[i].length && counter < n; j++){
                if(matrix[i][j] != 0){
                    if(!vertices[i]){
                        counter++;
                    }
                    if(!vertices[j]){
                        counter++;
                    }
                    vertices[i] = vertices[j] = true;
                }
            }
        }
        return counter;
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u ){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v)) {
            return false;
        } else {
            matrix[u][v] = w;
            return true;
        }
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u ){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v) || hasEdge(v,u)){
            return false;
        } else {
            matrix[u][v] = matrix[v][u] = w;
            return true;
        }
    }

    @Override
    public boolean removeEdge(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v)){
            matrix[u][v] = 0;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeEdgeU(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v) || hasEdge(v,u)){
            matrix[u][v] = matrix[v][u] = 0;
            return true;
        }
//        if(hasEdgeU(u,v)){
//            matrix[u][v] = matrix[v][u] = 0;
//            return true;
//        }
        return false;
    }

    @Override
    public boolean hasEdge(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        return matrix[u][v] != 0;
    }

    @Override
    public boolean hasEdgeU(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        return matrix[u][v] != 0 && matrix[v][u] != 0 && matrix[u][v] == matrix[v][u];
    }

    @Override
    public List<Integer> verticesConnectedTo(int v) {
        if(v < 0 || v >= n){
            throw new IllegalArgumentException();
        }
        List<Integer> vertices = new ArrayList<>();
        for(int j = 0; j < matrix[v].length; j++){
            if(matrix[v][j] != 0){
                vertices.add(j);
            }
        }
        return vertices;
    }

    @Override
    public double weight(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v)){
            return matrix[u][v];
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    @Override
    public void weight(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u ){
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v)){
            matrix[u][v] = w;
        }
    }

    public int getN(){
        return this.n;
    }

    @Override
    public Iterator<WeightedEdge> edges(int v) {
        return new Iterator<WeightedEdge>(matrix[v],v);
    }
}
