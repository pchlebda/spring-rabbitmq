package pl.pc.rabbit;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    public void onMessage(final String message) {
        System.out.println("Received " + message);
        countDownLatch.countDown();
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }
}
