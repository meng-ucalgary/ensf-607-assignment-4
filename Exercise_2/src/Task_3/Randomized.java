package Task_3;

import java.util.ArrayList;
import java.util.Random;

public class Randomized implements Runnable {
    static private ArrayList<Integer> generatedNumbers = new ArrayList<>();

    @Override
    public void run() {
        Random r = new Random();

        int generatedNumber = r.nextInt(100) + 1;
        Randomized.addGeneratedNumbers(generatedNumber);

        System.out.printf("Generated randomized number = %3s%n", String.format("%d", generatedNumber));
    }

    public static synchronized void addGeneratedNumbers(int num) {
        Randomized.generatedNumbers.add(num);
    }

    public static int getSum() {
        int sum = 0;

        for (int i = 0; i < Randomized.generatedNumbers.size(); i++) {
            sum += Randomized.generatedNumbers.get(i);
        }

        return sum;
    }
}
