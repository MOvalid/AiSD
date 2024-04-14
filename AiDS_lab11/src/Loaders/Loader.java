package Loaders;

import Digraphs.AdjacencyListWeightedDigraph;
import Digraphs.AdjacencyMatrixWeightedDigraph;
import Digraphs.IWeightedDigraph;
import Exceptions.MalformedGraphDescriptionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Loader {
    private static Scanner scanner;
    private static Pattern pattern;
    private static Matcher matcher;

    static IWeightedDigraph loadDigraph(String path, String expectedText, String pattern2, boolean isDirected, int choice) throws MalformedGraphDescriptionException {
        if(path == null){
            throw new IllegalArgumentException();
        }
        int line = 1;
        boolean exist, uncorrectSize;
        int u, v;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pattern = Pattern.compile("\\s*(\\d+)\\s*");
        String stringLine = scanner.nextLine();
        IWeightedDigraph digraph;
        matcher = pattern.matcher(stringLine);
        if(matcher.matches()){
            switch (choice){
                case 1 :
                    digraph = new AdjacencyMatrixWeightedDigraph(Integer.parseInt(matcher.group(1)));
                    break;
                case 2 :
                    digraph = new AdjacencyListWeightedDigraph(Integer.parseInt(matcher.group(1)));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
            pattern = Pattern.compile(pattern2);
            while(scanner.hasNextLine()){
                stringLine = scanner.nextLine();
                matcher = pattern.matcher(stringLine);
                line++;
                if(matcher.matches()){
                    u = Integer.parseInt(matcher.group(2));
                    v = Integer.parseInt(matcher.group(3));
                    uncorrectSize = u >= digraph.getN() || v >= digraph.getN();
                    if(matcher.group(1).isBlank() && isDirected){
                        exist = digraph.addEdge(u, v, Double.parseDouble(matcher.group(4)));
                    } else {
                        exist = digraph.addEdgeU(u, v, Double.parseDouble(matcher.group(4)));
                    }
                    if(!exist){
                        throw new MalformedGraphDescriptionException(line, "This edge is already exist!", stringLine);
                    }
                    if(uncorrectSize){
                        throw new MalformedGraphDescriptionException(line, "Vertex isn't smaller than size " + "(" + digraph.getN() + ") !", stringLine);
                    }
                } else {
                    throw new MalformedGraphDescriptionException(line, expectedText, stringLine);
                }
            }
        } else {
            throw new MalformedGraphDescriptionException(line, "non-negative integer", stringLine);
        }
        return digraph;
    }


}
