/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adl.RabbitMQPracticeService;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sahan
 */

@RestController
@RequestMapping(value = "/rabbitmq-practice")
public class RabbitMQController {
    
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    @GetMapping(value = "/send")
    public String producer(){
        String message1 = "Hi!!!";
        rabbitTemplate.convertAndSend(RabbitMqPracticeServiceApplication.EXCHANGE, RabbitMqPracticeServiceApplication.ROUTING_KEY,message1);
        System.out.println("Msg sent");
        return "message successfully sent!";
    }
}
