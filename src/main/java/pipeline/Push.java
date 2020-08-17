package pipeline;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Push {
    public static void main(String[] args) throws Exception {
        // Prepare our context and publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket sender = context.createSocket(SocketType.PUSH);
            sender.bind("tcp://localhost:5563");

            while (!Thread.currentThread().isInterrupted()) {
                sender.send("Random number : " + (int)(Math.random()*1000));
            }
        }
    }
}
