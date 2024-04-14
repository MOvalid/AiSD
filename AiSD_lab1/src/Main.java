public class Main {

    public static void main(String[] args) {
        int n = 1;
        int h = 3;
        System.out.println("Zadanie 1a:");
        System.out.println("Piramida dla n=" + n + " i h=" + h +":") ;
        drawPyramid2(n,h);

        System.out.println("\n---------------------\n");

        n = 6;
        System.out.println("Zadanie 1b:");
        System.out.println("Figura dla n=" + n + ":");
        drawAFigure(n);

        System.out.println("\n---------------------\n");

        System.out.println("Zadanie 2:");
        pairSwap("Ala lot=_t0l ma kot=1pies kota");
        System.out.println();
        pairSwap("Litw0=0jczyzno moja, Ty jestes jak zdr0w13, ile C13=c3n1c, t3n ty1k0 si3 d0wie=_kt0 C13 stracil.");

        n = 3;
        System.out.println("\nModyfikacja dla n=" + n + ": \n");
        drawJoinedTriangles(n);
    }

    public static void drawPyramid(int n, int h){
        int free = h-1;
        int howMuchSpace;
        int howMuchX;
        if(n >= 0 && h >= 0){
            while(free >= 0){
                howMuchX= 2*(n+h-free)-1;
                howMuchSpace = 0;
                while (howMuchSpace < free){
                    System.out.print(" ");
                    howMuchSpace++;
                }
                while (howMuchX > 0){
                    System.out.print("X");
                    howMuchX--;
                }
                while(howMuchSpace > 0){
                    System.out.print(" ");
                    howMuchSpace--;

                }
                free--;
                System.out.println();
            }
        } else {
            System.out.println("Błędne dane - ani wysokość, ani szerokość nie mogą być mniejsze od zera!");
        }
    }


    public static void drawPyramid2(int n, int h) {
        int free = 0;
        if (n >= 0 && h >= 0) {
            char[][] pyramid = new char[h][(2 * (n + h)) - 1];
            for (int x = 0; x < h; x++) {
                for (int y = (pyramid[x].length - 1); y >= 0; y--) {
                    pyramid[x][y] = 'X';
                    free = (h - 1) - x;
                    for (int z = 0; z < free; z++) {
                        pyramid[x][pyramid[x].length - 1 - z] = ' ';
                        pyramid[x][z] = ' ';
                    }
                    System.out.print(pyramid[x][y]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Błędne dane - wysokość ani szerokość nie mogą być mniejsze od zera!");
        }
    }

    public static void drawAFigure(int n) {
        for (int x = 0; x < n; x++) {
            drawPyramid2(x, (n - x));
        }
    }


    public static void pairSwap(String text) {
        System.out.println("\nPrzed:\n" + text + "\n");
        if (text != null) {
            String[] textArray = text.split(" ");
            System.out.println("Po: ");
            for (String s : textArray) {
                char[] charArray = s.toCharArray();
                if(hasEqualSign(charArray)){
                    if(checkingID(charArray)){
                        s = switchText(s);
                    }
                }
                System.out.print(s + " ");
            }
            System.out.println();
            } else{
                System.out.println(" ");
            }
        }



    public static boolean hasEqualSign(char[] charArray){
        boolean hasEqualsign = false;
        int howMuchSigns = 0;

        for(char c : charArray){
            if(c == '='){
                howMuchSigns++;
            }
        }
        if(howMuchSigns == 1){
            hasEqualsign = true;
        }
        return (hasEqualsign);
    }

    public static boolean checkingID(char[] charArray){
        boolean isCorrect = true;
        if(Character.isLetter(charArray[0]) || charArray[0] == '_') {
            for (int x = 1; x < charArray.length; x++) {
                if (Character.isDigit(charArray[x]) || Character.isLetter(charArray[x]) || charArray[x] == '=') {
                    if(charArray[x] == '='){
                        if (charArray[x+1] == '_' || Character.isLetter(charArray[x+1])){
                            x++;
                        } else {
                            isCorrect = false;
                            break;
                        }
                    }
                } else {
                    isCorrect = false;
                    break;
                }

            }
        } else {
            isCorrect = false;
        }
        return isCorrect;
    }

    public static String switchText(String text) {
//        Zamienia słowa oddzielone '='
        String[] splitText = text.split("=");
        String newString = splitText[1] + "=" + splitText[0];
        return newString;
    }


    public static void drawJoinedTriangles(int n){
        if (n >= 0) {
            char[][] pyramid = new char[n+1][2*n + 1];
            for (int x = 0; x < pyramid.length; x++) {
                for (int y = 0; y < pyramid[x].length; y++) {
                    pyramid[x][y] = ' ';

                    if(x == 0 || x == pyramid.length-1){
                        pyramid[x][y] = 'X';
                    } else {
                        pyramid[x][x] = 'X';
                        pyramid[x][pyramid[x].length-1-x] = 'X';

                        pyramid[x][pyramid.length-1-x] = 'X';
                        pyramid[x][pyramid[x].length-pyramid.length+x] = 'X';

                    }

                    System.out.print(pyramid[x][y]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Błędne dane - n nie może być mniejsze od zera!");
        }
    }

}
