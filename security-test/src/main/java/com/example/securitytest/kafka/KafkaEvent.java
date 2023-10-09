package com.example.securitytest.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author 雨天留恋
 * @date 2023-07-15 13:11
 */
@Component
public class KafkaEvent {

    // @KafkaListener(topics = "my_topic")
    // public void processMessage(String content) {
    //     System.out.println(content);
    // }
}
