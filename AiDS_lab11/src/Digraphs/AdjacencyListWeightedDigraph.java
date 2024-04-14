package Digraphs;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListWeightedDigraph implements IWeightedDigraph {

    private class Element{
        private int vertex;
        private double weigth;
        private Element next;

        private Element(int vertex, double weigth, Element next){
            if(vertex < 0){
                throw new IllegalArgumentException();
            }
            this.vertex = vertex;
            this.weigth = weigth;
            this.next = next;
        }
    }

    private class Iterator<WeigthedEdge> implements java.util.Iterator<WeightedEdge> {
        private Element actual;
        private final int v;

        Iterator(Element actual, int v){
            this.actual = actual;
            this.v = v;
        }

        public boolean hasNext(){
           return actual != null;
        }

        public WeightedEdge next(){
            if(hasNext()) {
                WeightedEdge edge = new WeightedEdge(v, actual.vertex, actual.weigth);
                actual = actual.next;
                return edge;
            }
            return null;
        }
    }

    private List<Element> neighborhoodList;
    private int n;

    public AdjacencyListWeightedDigraph(int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        this.neighborhoodList = new ArrayList<Element>(n);
        for(int i = 0; i < n; i++){
            neighborhoodList.add(null);
        }
        this.n = n;
    }

    @Override
    public int edgeCount() {
        int edges = 0;
        Element actual;
        for(int i = 0; i < neighborhoodList.size(); i++){
            actual = neighborhoodList.get(i);
            while(actual != null){
                edges++;
                actual = actual.next;
            }
        }
        return edges;
    }

    @Override
    public int vertexCount() {
        int counter = 0;
        boolean[] vertices = new boolean[n];
        Element actual;
        for(int i = 0; i < neighborhoodList.size() && counter < n; i++){
            actual = neighborhoodList.get(i);
            while(actual != null && counter < n){
                if (!vertices[i]){
                    counter++;
                }
                if(!vertices[actual.vertex]){
                    counter++;
                }
                vertices[i] = vertices[actual.vertex] = true;
                actual = actual.next;
            }
        }
        return counter;
    }

    @Override
    public boolean addEdge(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        Element previous = null;
        Element actual = neighborhoodList.get(u);
        while(actual != null){
            if(actual.vertex == v){
                return false;
            }
            previous = actual;
            actual = actual.next;
        }
        if(previous != null){
            previous.next = new Element(v, w, null);
        } else {
            neighborhoodList.set(u, new Element(v, w, null));
        }
        return true;
    }

    @Override
    public boolean addEdgeU(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        if(hasEdgeU(u, v)){
            return false;
        } else {
            return addEdge(u,v,w) && addEdge(v,u,w);
        }
    }

    @Override
    public boolean removeEdge(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        Element previous = null;
        Element actual = neighborhoodList.get(u);
        while(actual != null){
            if(actual.vertex == v) {
                if (previous != null) {
                    previous.next = actual.next;
                } else {
                    neighborhoodList.set(u, null);
                }
                return true;
            }
            previous = actual;
            actual = actual.next;
        }
        return false;
    }

    @Override
    public Iterator<WeightedEdge> edges(int v) {
        if(v < 0 || v >= n){
            throw new IllegalArgumentException();
        }
        return new Iterator(neighborhoodList.get(v),v);
    }

    @Override
    public boolean removeEdgeU(int u, int v) {
        if (u < 0 || v < 0 || n <= v || n <= u) {
            throw new IllegalArgumentException();
        }
        if(hasEdge(u,v) || hasEdge(v,u)){
            return removeEdge(u,v) || removeEdge(v,u);
        }
//        if(hasEdgeU(u,v)){
//            return removeEdge(u,v) && removeEdge(v,u);
//        }
        return false;
    }

    @Override
    public boolean hasEdge(int u, int v) {
        Element actual = neighborhoodList.get(u);
        while (actual != null) {
            if (actual.vertex == v) {
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    @Override
    public boolean hasEdgeU(int u, int v) {
        return hasEdge(u, v) && hasEdge(v, u) && weight(u,v) == weight(v,u);
    }

    @Override
    public List<Integer> verticesConnectedTo(int v) {
        if(v < 0 || v >= n){
            throw new IllegalArgumentException();
        }
        List<Integer> vericesConnected = new ArrayList<>();
        Element actual = neighborhoodList.get(v);
        while(actual != null){
            vericesConnected.add(actual.vertex);
            actual = actual.next;
        }
        return vericesConnected;
    }

    @Override
    public double weight(int u, int v) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        Element actual = neighborhoodList.get(u);
        while(actual != null){
            if(actual.vertex == v){
                return actual.weigth;
            }
            actual = actual.next;
        }
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public void weight(int u, int v, double w) {
        if(u < 0 || v < 0 || n <= v || n <= u){
            throw new IllegalArgumentException();
        }
        Element actual = neighborhoodList.get(u);
        while(actual != null){
            if(actual.vertex == v){
               actual.weigth = w;
               break;
            }
            actual = actual.next;
        }
    }

    public int getN(){
        return this.n;
    }
}
