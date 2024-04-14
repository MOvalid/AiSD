import Converters.Converter;
import Digraphs.AdjacencyListWeightedDigraph;
import Digraphs.AdjacencyMatrixWeightedDigraph;
import Digraphs.WeightedEdge;
import Exceptions.MalformedGraphDescriptionException;
import Loaders.ListGraphLoader;
import Loaders.MatrixGraphLoader;

import java.util.Iterator;
import java.util.List;

public class main {

    private static String path = "C:\\Users\\trine\\OneDrive\\Pulpit\\test11.txt";

    public static void main(String[] args) throws MalformedGraphDescriptionException {

        AdjacencyMatrixWeightedDigraph matrix = new AdjacencyMatrixWeightedDigraph(5);
        System.out.println(matrix.addEdge(4,3,3));
        System.out.println(matrix.addEdge(4,3,3));
        System.out.println(matrix.addEdge(4,2,2));
        System.out.println(matrix.addEdgeU(4,3,3));
        System.out.println(matrix.addEdgeU(1,2,-9));
        System.out.println(matrix.edgeCount());
        System.out.println(matrix.vertexCount());

        System.out.println("----------------");
        List<Integer> matrixList = matrix.verticesConnectedTo(4);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(3);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(2);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(1);
        printList(matrixList);

        System.out.println("#################");
        Iterator<WeightedEdge> matrixIterator = matrix.edges(4);
        while(matrixIterator.hasNext()){
            System.out.println(matrixIterator.next());
        }

        System.out.println("----------------");

        AdjacencyListWeightedDigraph list = new AdjacencyListWeightedDigraph(5);
        System.out.println(list.addEdge(4,3,3));
        System.out.println(list.addEdge(4,3,3));
        System.out.println(list.addEdge(4,2,2));
        System.out.println(list.addEdgeU(4,3,3));
        System.out.println(list.addEdgeU(1,2,-9));
        System.out.println(list.edgeCount());
        System.out.println(list.vertexCount());

        System.out.println("#################");
        List<Integer> listlist = list.verticesConnectedTo(4);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(3);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(2);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(1);
        printList(listlist);

        System.out.println("#################");
        Iterator<WeightedEdge> listIterator = list.edges(4);
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println("#################");
        Converter converter = new Converter();
        AdjacencyMatrixWeightedDigraph convertedMatrix = (AdjacencyMatrixWeightedDigraph) converter.convert(list);
        System.out.println(convertedMatrix.addEdge(4,3,3));
        System.out.println(convertedMatrix.addEdge(4,3,3));
        System.out.println(convertedMatrix.addEdgeU(4,3,3));
        System.out.println(convertedMatrix.addEdgeU(1,2,-9));
        System.out.println(convertedMatrix.edgeCount());
        System.out.println(convertedMatrix.vertexCount());

        System.out.println("----------------");
        matrixList = convertedMatrix.verticesConnectedTo(4);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = convertedMatrix.verticesConnectedTo(3);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = convertedMatrix.verticesConnectedTo(2);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = convertedMatrix.verticesConnectedTo(1);
        printList(matrixList);



        System.out.println("#################");
        AdjacencyListWeightedDigraph convertedList = (AdjacencyListWeightedDigraph) converter.convert(matrix);
        System.out.println(convertedList.addEdge(4,3,3));
        System.out.println(convertedList.addEdge(4,3,3));
        System.out.println(convertedList.addEdgeU(4,3,3));
        System.out.println(convertedList.addEdgeU(1,2,-9));
        System.out.println(convertedList.edgeCount());
        System.out.println(convertedList.vertexCount());

        System.out.println("----------------");
        listlist = convertedList.verticesConnectedTo(4);
        printList(listlist);

        System.out.println("----------------");
        listlist = convertedList.verticesConnectedTo(3);
        printList(listlist);

        System.out.println("----------------");
        listlist = convertedList.verticesConnectedTo(2);
        printList(listlist);

        System.out.println("----------------");
        listlist = convertedList.verticesConnectedTo(1);
        printList(listlist);

        System.out.println("#################");
        matrix = MatrixGraphLoader.loadDirectedGraph(path);
        System.out.println(matrix.addEdge(4,3,3));
        System.out.println(matrix.addEdge(4,3,3));
        System.out.println(matrix.addEdgeU(4,3,3));
        System.out.println(matrix.addEdgeU(1,2,-9));
        System.out.println(matrix.edgeCount());
        System.out.println(matrix.vertexCount());

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(4);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(3);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(2);
        printList(matrixList);

        System.out.println("----------------");
        matrixList = matrix.verticesConnectedTo(1);
        printList(matrixList);

        System.out.println("#################");
        Iterator<WeightedEdge> loadMatrixIterator = matrix.edges(4);
        while(loadMatrixIterator.hasNext()){
            System.out.println(loadMatrixIterator.next());
        }

        System.out.println("#################");
        list = ListGraphLoader.loadDirectedGraph(path);
        System.out.println(list.addEdge(4,3,3));
        System.out.println(list.addEdge(4,3,3));
        System.out.println(list.addEdgeU(4,3,3));
        System.out.println(list.addEdgeU(1,2,-9));
        System.out.println(list.edgeCount());
        System.out.println(list.vertexCount());

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(4);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(3);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(2);
        printList(listlist);

        System.out.println("----------------");
        listlist = list.verticesConnectedTo(1);
        printList(listlist);

        System.out.println("#################");
        Iterator<WeightedEdge> loadListIterator = list.edges(4);
        while(loadListIterator.hasNext()){
            System.out.println(loadListIterator.next());
        }
    }

    private static void printList(List<Integer> list){
        for(int i = 0 ; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
