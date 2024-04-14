package HashFunctions;

public class Example implements HashFunction<Integer> {
    @Override
    public int hashCode(Integer object) {
        String number = object.toString();
        int hash = 1;
        char c;
        for(int i = 0; i < number.length(); i++){
            c = number.charAt(i);
            if(c != '-') {
                if(i % 2 == 0) {
                    hash = hash + 2 * (i+1) * Integer.parseInt(String.valueOf(c));
                } else {
                    hash = hash + (i+1) * Integer.parseInt(String.valueOf(c));
                }
            } else {
                hash = hash + 5;
            }
        }
        return 31 * hash + 37;
    }
}
