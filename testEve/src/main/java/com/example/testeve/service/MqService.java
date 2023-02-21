package com.example.testeve.service;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author 雨天留恋
 * @date 2022-12-07 20:17
 */
@Service
public class MqService {

    @RabbitListener(queues = "messageQueue")
    public void receiveMessage(String message){
        System.out.println(message);
    }
    @RabbitListener(queues = "exeQueue")
    public void receiveExecutor(String exe){
        System.out.println(exe);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "messageQueue"),
            exchange = @Exchange(name = "exchange",type  = ExchangeTypes.TOPIC),
            key = {"error"}
    ))
    public void receive(String message) {
        System.out.println(message);
    }
}
