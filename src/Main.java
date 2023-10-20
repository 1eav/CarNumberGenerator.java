import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //TIME: 1-11834 ms, 2-11967 ms; SIZE: 1-1,39 gb, 2-1,39 gb "Cинхронизация потоков"
        Object sync = new Object();
        new Thread(() -> {
            synchronized (sync) {
                try {
                    Loader.loader("res/numbers1.txt");
                    sync.wait();
                } catch (FileNotFoundException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (sync) {
                try {
                    Loader.loader("res/numbers2.txt");
                    sync.notify();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}