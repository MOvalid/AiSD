package Digraphs;

import java.util.Iterator;
import java.util.List;

public interface IWeightedDigraph {
    int edgeCount();							// Returns the number of edges in the graph
    int vertexCount();							// Returns the number of vertices in the graph

    boolean addEdge(int u, int v, double w); 	// Adds directed edge (u, v) of weight w to the graph.
                                                // Returns true if added, false if the edge already exists.

    boolean addEdgeU(int u, int v, double w); 	// Adds undirected edge (u, v) of weight w to the graph.
                                                // Returns true if added, false if the edge already exists.

    boolean removeEdge(int u, int v); 			// Removes the directed edge (u, v) from the graph.
                                                // Returns true if successful, false if there is no such edge.

    boolean removeEdgeU(int u, int v); 			// Removes the undirected edge (u, v) from the graph.
                                                // If the edge is directed, removes it as well.
                                                // Returns true if successful, false if there is no such edge.

    boolean hasEdge(int u, int v);				// Returns whether the directed edge (u, v) is currently in the graph.

    boolean hasEdgeU(int u, int v);				// Returns whether the undirected edge (u, v) is currently in the graph.

    List<WeightedEdge> verticesConnectedTo(int v);	// Returns list of vertices connected to the vertex v - { u : (v, u) in E }.

    List<WeightedEdge> allUndirectedVertices();	// Returns list of vertices connected to the vertex v - { u : (v, u) in E }.

    double weight(int u, int v); 				// Returns the weight of the directed edge (u, v).
                                                // If there is no such edge, returns positive infinity.

    void weight(int u, int v, double w); 		// Sets the weight of the directed edge (u, v).
                                                // If there is no such edge, does nothing.
    int getN();

    WeightedEdge getMinEdge();

    Iterator<WeightedEdge> edges(int v);

    boolean isUndirected();
}
