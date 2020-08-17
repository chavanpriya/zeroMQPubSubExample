package src;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Publisher {
    public static void main(String[] args) throws Exception {
        // Prepare our context and publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
            publisher.bind("tcp://*:5563");

            while (!Thread.currentThread().isInterrupted()) {
                publisher.sendMore("A");
                publisher.send("Random number : " + (int)(Math.random()*1000));
            }
        }
    }
}
