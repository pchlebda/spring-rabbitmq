package pl.pc.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public CmdRunner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message..");
        rabbitTemplate.convertAndSend(RabbitApplication.TOPIC_EXCHANGE_NAME, RabbitApplication.ROUTING_KEY, "Hello World!");
        receiver.getCountDownLatch().await();
    }
}
