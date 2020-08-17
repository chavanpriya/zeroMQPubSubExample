package pipeline;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Collect {
    public static void main(String[] args) {
        // Prepare our context and subscriber
        try (ZContext context = new ZContext()) {
            ZMQ.Socket receiver = context.createSocket(SocketType.PULL);
            receiver.connect("tcp://localhost:5564");

            while (!Thread.currentThread().isInterrupted()) {
                String contents = receiver.recvStr();
                System.out.println(contents);
            }
        }
    }
}
