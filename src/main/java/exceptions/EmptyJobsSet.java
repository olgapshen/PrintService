package exceptions;

public class EmptyJobsSet extends RuntimeException {
    public EmptyJobsSet() {
        super("Empty jobs set");
    }
}
