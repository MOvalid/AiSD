public class RunResult {

    private long timeMillis;

    public RunResult(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    public long timeInMilliseconds() {
        return timeMillis;
    }

}

