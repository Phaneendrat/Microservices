package demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue1")
    public void consume(String message) {
        System.out.println("Received Message: " + message);
    }
}