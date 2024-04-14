import Algorithms.Kruskal;
import Algorithms.Prim;
import Algorithms.Prim1;
import Digraphs.AdjacencyListWeightedDigraph;
import Digraphs.AdjacencyMatrixWeightedDigraph;
import Exceptions.MalformedGraphDescriptionException;
import Loaders.ListGraphLoader;
import Loaders.MatrixGraphLoader;

import java.util.List;
import java.util.Random;

public class main {

    private static String path1 = "C:\\Users\\trine\\OneDrive\\Pulpit\\test11.txt";
    private static String path2 = "C:\\Users\\trine\\OneDrive\\Pulpit\\test12.txt";
    private static String path3 = "C:\\Users\\trine\\OneDrive\\Pulpit\\test13.txt";
    private static String path4 = "C:\\Users\\trine\\OneDrive\\Pulpit\\test14.txt";
    private static Random random = new Random();

    public static void main(String[] args) throws MalformedGraphDescriptionException {
        AdjacencyMatrixWeightedDigraph matrix = MatrixGraphLoader.loadDirectedGraph(path1);

        System.out.println("GRAF NR.1");
        System.out.println("KRUSKAL");
        printList(Kruskal.getMinimalTree(matrix));
        System.out.println("-------------");
        System.out.println("PRIM");
        printList(Prim1.prim(matrix));
        System.out.println("-------------");
//
        AdjacencyListWeightedDigraph list = ListGraphLoader.loadUndirectedGraph(path2);

//        printList(Prim1.prim(list));
//
        System.out.println("GRAF NR.2");
        System.out.println("KRUSKAL");
        printList(Kruskal.getMinimalTree(list));
        System.out.println("-------------");
        System.out.println("PRIM");
        printList(Prim1.prim(list));
        System.out.println("-------------");
//
//
        matrix = MatrixGraphLoader.loadDirectedGraph(path3);

        System.out.println("GRAF NR.3");
        System.out.println("KRUSKAL");
        printList(Kruskal.getMinimalTree(matrix));
        System.out.println("-------------");
        System.out.println("PRIM");
        printList(Prim1.prim(matrix));
        System.out.println("-------------");

//
        start(1000,20000, 10,1,2000);
    }

    private static <T> void printList(List<T> list){
        for(int i = 0 ; i< list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static void start(int vertices, int edges, int repetitions, int minWeight, int maxWeight){
        double matrixKruskalTime = 0;
        double listKruskalTime = 0;
        double anotherMatrixPrimTime = 0;
        double anotherListPrimTime = 0;
        long start, end;
        int endVertex, weigth, k;
        AdjacencyMatrixWeightedDigraph matrix;
        AdjacencyListWeightedDigraph list;
        for(int i = 0; i < repetitions; i++){
            matrix = new AdjacencyMatrixWeightedDigraph(vertices);
            list = new AdjacencyListWeightedDigraph(vertices);
            k = 0;
            for(int j = 0; j < edges; j++){
                endVertex = random.nextInt(0,vertices);
                weigth = random.nextInt(minWeight, maxWeight+1);
                matrix.addEdgeU(k,endVertex,weigth);
                list.addEdgeU(k,endVertex,weigth);
                k++;
                if(k == vertices){
                    k = 0;
                }
            }

            start = System.currentTimeMillis();
            Kruskal.getMinimalTree(matrix);
            end = System.currentTimeMillis();

            matrixKruskalTime += (double) end - start;

            start = System.currentTimeMillis();
            Kruskal.getMinimalTree(list);
            end = System.currentTimeMillis();

            listKruskalTime += (double) end - start;


            start = System.currentTimeMillis();
            Prim1.prim(matrix);
            end = System.currentTimeMillis();

            anotherMatrixPrimTime += (double) end - start;

            start = System.currentTimeMillis();
            Prim1.prim(list);
            end = System.currentTimeMillis();

            anotherListPrimTime += (double) end - start;

        }

        printStatistics(doubleToString(matrixKruskalTime/repetitions), "MATRIX", "KRUSKAL");
        printStatistics(doubleToString(listKruskalTime/repetitions), "\nLIST", "KRUSKAL");
        printStatistics(doubleToString(anotherMatrixPrimTime/repetitions), "\nMATRIX", "PRIM");
        printStatistics(doubleToString(anotherListPrimTime/repetitions), "\nLIST", "PRIM");

    }

    private static void printStatistics(String time, String label, String method){
        System.out.println(label + " " + method);
        System.out.println("time: " + time + " [ms]");
    }

    private static String doubleToString(double value){
        return String.format("%.12f", value);
    }

}
