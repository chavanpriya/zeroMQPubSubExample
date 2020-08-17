import src.Publisher;
import src.Subscriber;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Publisher.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Subscriber.main(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
