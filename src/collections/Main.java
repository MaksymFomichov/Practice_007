package collections;

public class Main {

    public static void main(String[] args) {

        PerfomanceChecker perfomanceChecker = new PerfomanceChecker();

        perfomanceChecker.checkAdding(10000);
        perfomanceChecker.checkReading(10000);
        perfomanceChecker.checkRemoving(10000);
    }
}
