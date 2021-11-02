package Task_2;

public class Driver {
    static final int n = 5;

    public static void main(String[] args) {
        // create n number of objects of Randomized
        Randomized[] randomized_list = new Randomized[Driver.n];

        for (int i = 0; i < randomized_list.length; i++) {
            randomized_list[i] = new Randomized();
        }

        // create n number of threads
        Thread[] thread_list = new Thread[Driver.n];

        for (int i = 0; i < thread_list.length; i++) {
            thread_list[i] = new Thread(randomized_list[i]);
            thread_list[i].start();
        }

        try {
            // wait to complete all threads
            for (int i = 0; i < thread_list.length; i++) {
                thread_list[i].join();
            }
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%nSum of generated numbers = %d%n", Randomized.getSum());
    }
}
