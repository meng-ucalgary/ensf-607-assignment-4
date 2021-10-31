public class SimpleThread implements Runnable {
    Resource resource;

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(resource.increment());
                Thread.sleep(1);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    SimpleThread(Resource resource) {
        this.resource = resource;
    }

    public static void main(String args[]) {
        SimpleThread obj = new SimpleThread(new Resource());

        Thread t = new Thread(obj);
        Thread s = new Thread(obj);

        t.start();
        s.start();
    }
}
