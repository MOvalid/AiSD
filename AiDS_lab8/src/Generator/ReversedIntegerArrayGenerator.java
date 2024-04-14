package Generator;

import java.util.ArrayList;
import java.util.List;

public class ReversedIntegerArrayGenerator implements Generator<Integer> {
    @Override
    public List<Integer> generate(int size) {
        List<Integer> list = new ArrayList<Integer>(size);

        for(int i = size - 1; i >= 0; --i) {
            list.add(i);
        }

        return list;
    }
}
