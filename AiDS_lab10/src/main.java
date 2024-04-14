import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    private static Random random = new Random();

    public static void main(String[] args) {

        generateListSets(8000000,100000,10000,10000,10);


    }

    public static void generateListSets(int size, int unions, int joints, int findSets, int repetitions) {
        if (size < 0 || unions < 0 || joints < 0 || findSets < 0 || repetitions < 0) {
            throw new IllegalArgumentException();
        }
        ListDisjointSet listDS;
        ForestDisjointSet forestDS;

        List<ListElement> listSets = new ArrayList<>(size);
        List<ForestElement> forestSets = new ArrayList<>(size);
        int[] indexes1;
        int[] indexes2;
        int[] indexes3;
        String lds = "\nLIST DISJOINT SET";
        String fds = "FOREST DISJOINT SET";
        long start, end;
        double listUnion = 0, forestUnion = 0, listJoint = 0, forestJoint = 0, listFindSet = 0, forestFindSet = 0;

        for (int j = 0; j < repetitions; j++) {
            listSets.clear();
            forestSets.clear();
            listDS = new ListDisjointSet();
            forestDS = new ForestDisjointSet();
            indexes1 = generateArray(2*unions, size);
            indexes2 = generateArray(2*joints, size);
            indexes3 = generateArray(findSets, size);

            for (int i = 0; i < size; i++) {
                listSets.add(listDS.makeSet());
                forestSets.add(forestDS.makeSet());
            }

            start = System.currentTimeMillis();

            for (int i = 0; i < 2 * unions; i = i + 2) {
                listDS.union(listSets.get(indexes1[i]),listSets.get(indexes1[i + 1]) );
            }

            end = System.currentTimeMillis();
            listUnion += (double) end - start;
            start = System.currentTimeMillis();

            for (int i = 0; i < 2 * unions; i = i + 2) {
                forestDS.union(forestSets.get(indexes1[i]),forestSets.get(indexes1[i + 1]) );
            }

            end = System.currentTimeMillis();
            forestUnion += (double) end - start;
            start = System.currentTimeMillis();

            for (int i = 0; i < 2 * joints; i = i + 2) {
                listDS.isJoint(listSets.get(indexes2[i]), listSets.get(indexes2[i+1]));
            }

            end = System.currentTimeMillis();
            listJoint += (double) end - start;
            start = System.currentTimeMillis();


            for (int i = 0; i < 2 * joints; i = i + 2) {
                forestDS.isJoint(forestSets.get(indexes2[i]), forestSets.get(indexes2[i+1]));

            }

            end = System.currentTimeMillis();
            forestJoint += (double) end - start;
            start = System.currentTimeMillis();

            for(int i = 0; i < findSets; i++){
                listDS.findSet(listSets.get(indexes3[i]));
            }

            end = System.currentTimeMillis();
            listFindSet += (double) end - start;
            start = System.currentTimeMillis();

            for(int i = 0; i < findSets; i++){
                forestDS.findSet(forestSets.get(indexes3[i]));
            }

            end = System.currentTimeMillis();
            forestFindSet += (double) end - start;
        }

        printStatistics(doubleToString(listUnion/repetitions), lds, "UNION" );
        printStatistics(doubleToString(forestUnion/repetitions), fds, "UNION" );
        printStatistics(doubleToString(listJoint/repetitions), lds, "JOINT" );
        printStatistics(doubleToString(forestJoint/repetitions), fds, "JOINT" );
        printStatistics(doubleToString(listFindSet/repetitions), lds, "FIND-SET" );
        printStatistics(doubleToString(forestFindSet/repetitions), fds, "FIND-SET" );

    }

    private static void printStatistics(String time, String label, String method){
        System.out.println(label + " " + method);
        System.out.println("time: " + time + " [ms]");
    }

    private static String doubleToString(double value){
        return String.format("%.12f", value);
    }

    private static int[] generateArray(int size, int maxValue){
        int[] array = new int[size];
        for(int i = 0; i < size; i = i + 2){
            array[i] = random.nextInt(0,maxValue);
        }
        return array;
    }


}
