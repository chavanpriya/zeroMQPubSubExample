package pipeline;

import src.Publisher;
import src.Subscriber;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Push.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Pull.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Collect.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
