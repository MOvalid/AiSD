package Generator;

import java.util.ArrayList;
import java.util.List;

public class OrderedIntegerArrayGenerator implements Generator<Integer> {
    @Override
    public List<Integer> generate(int size) {
        List<Integer> list = new ArrayList<>(size);

        for(int i = 0; i < size; i++){
            list.add(i);
        }
        return list;
    }
}
