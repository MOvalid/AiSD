import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Tester {

    public static <T> RunResult runOnce(int size, Heap<T> heap, List<T> list) {
        PriorityQueueSorter<T> queue = new PriorityQueueSorter<>(heap);

        Instant start = Instant.now();
        queue.sort(list);
        Instant end = Instant.now();

        return new RunResult(Duration.between(start, end).toMillis());
    }

}
