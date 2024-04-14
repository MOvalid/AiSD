package HashFunctions;

public class IntegerHashFunction<Integer> implements HashFunction<Integer> {
    @Override
    public int hashCode(Integer object) {
        int hash = (int) object;
        hash = hash * hash - hash;
        if ((int) object % 2 == 1) {
            return hash + 1;
        } else {
            return hash;
        }
    }
}
