package HashFunctions;

public class NewIntegerHashFunction<Integer> implements HashFunction<Integer> {
    @Override
    public int hashCode(Integer object) {
       int hash = (int) object;
        hash ^= (hash << 13);
        hash ^= (hash >>> 17);
        hash ^= (hash << 5);
        if(hash < 0){
            hash = hash * (-1);
        }
        return hash;
    }
}
