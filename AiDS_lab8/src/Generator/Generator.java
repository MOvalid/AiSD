package Generator;

import java.util.List;

public interface Generator<T> {
    List<Integer> generate(int size);
}
