package Exceptions;

public class MalformedGraphDescriptionException extends Exception {

    public MalformedGraphDescriptionException(int line, String expected, String found){
        super("\nLine: " + line + "\nExpected: " + expected + "\nFound:  " + found);
    }
}
