package Task_1;

import java.util.Random;

public class Randomized implements Runnable {
    private int generatedNumber;

    @Override
    public void run() {
        Random r = new Random();
        this.setGeneratedNumber(r.nextInt(100) + 1);
        System.out.printf("Generated randomized number = %3s%n", String.format("%d", this.getGeneratedNumber()));
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber(int generatedNumber) {
        this.generatedNumber = generatedNumber;
    }
}
