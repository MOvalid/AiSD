package core;

import java.util.Random;

public class RandomPivot<T> implements ChoosePivot<T>{
    private Random random = new Random();
    @Override
    public int choosePivot(int start, int end) {
        return random.nextInt(start,end);
    }
}
