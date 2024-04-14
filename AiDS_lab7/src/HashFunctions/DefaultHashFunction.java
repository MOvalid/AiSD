package HashFunctions;

public class DefaultHashFunction<T> implements HashFunction<T> {
    @Override
    public int hashCode(T object) {
        return object.hashCode() + 111;
    }
}
