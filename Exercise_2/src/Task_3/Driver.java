package Task_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Driver {
    static final int n = 5;
    static private ExecutorService pool;

    public static void main(String[] args) {
        // create n number of objects of Randomized
        Randomized[] randomized_list = new Randomized[Driver.n];

        for (int i = 0; i < randomized_list.length; i++) {
            randomized_list[i] = new Randomized();
        }

        // create a Thread pool of five threads
        Driver.pool = Executors.newFixedThreadPool(Driver.n);

        for (int i = 0; i < randomized_list.length; i++) {
            Driver.pool.execute(randomized_list[i]);
        }

        Driver.pool.shutdown();

        // wait until shutdown happens
        try {
            Driver.pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.printf("%nSum of generated numbers = %d%n", Randomized.getSum());
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
