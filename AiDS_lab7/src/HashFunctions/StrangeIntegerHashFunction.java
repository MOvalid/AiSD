package HashFunctions;

public class StrangeIntegerHashFunction<Integer> implements HashFunction<Integer> {
    @Override
    public int hashCode(Integer object) {
        return (((((int)object + 27) * 3) % 7) * 11) % 19;
    }
}
