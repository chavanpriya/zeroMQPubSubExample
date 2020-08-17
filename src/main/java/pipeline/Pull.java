package pipeline;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Pull {
    public static void main(String[] args) {
        // Prepare our context and subscriber
        try (ZContext context = new ZContext()) {
            ZMQ.Socket receiver = context.createSocket(SocketType.PULL);
            receiver.connect("tcp://localhost:5563");

            ZMQ.Socket consumerSender = context.createSocket(SocketType.PUSH);
            consumerSender.bind("tcp://localhost:5564");

            long sequence = 1L;
            while (!Thread.currentThread().isInterrupted()) {
                String contents = receiver.recvStr();
                String result = "Seq No. " + sequence++ + " " + contents;
                consumerSender.send(result);
            }
        }
    }
}

