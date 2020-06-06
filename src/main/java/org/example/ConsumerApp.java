package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ConsumerApp {
    @Value("${queue.name}")
    private String queueName;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

    @RabbitListener(queues = "${queue.name}")
    public void listen(Message message) {
        log.info("Message read from " + queueName + " : " + message.getBody());
    }
}

