package com.example.testeve.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 雨天留恋
 * @date 2022-12-07 19:55
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue messageQueue() {
        return new Queue("messageQueue");
    }
//    @Bean
//    public Queue messageQueue2() {
//        return new Queue("messageQueue2");
//    }

    @Bean
    public Queue exeQueue() {
        return new Queue("exeQueue");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }


    @Bean
    public Binding bingingMessage(TopicExchange exchange, Queue messageQueue) {
        return BindingBuilder.bind(messageQueue).to(exchange).with("message");
    }
    @Bean
    public Binding bingingMessage1(TopicExchange exchange, Queue messageQueue) {
        return BindingBuilder.bind(messageQueue).to(exchange).with("all");
    }

    @Bean
    public Binding bingingExecutor(TopicExchange exchange, Queue exeQueue) {
        return BindingBuilder.bind(exeQueue).to(exchange).with("exe");
    }
    @Bean
    public Binding bingingExecutor1(TopicExchange exchange, Queue exeQueue) {
        return BindingBuilder.bind(exeQueue).to(exchange).with("all");
    }

}
