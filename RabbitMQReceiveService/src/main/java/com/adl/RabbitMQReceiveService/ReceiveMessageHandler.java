/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adl.RabbitMQReceiveService;

import org.springframework.stereotype.Service;

/**
 *
 * @author sahan
 */

@Service
class ReceiveMessageHandler {
    public void handleMessage(String messageBody){
        System.out.println("HandleMessage!");
        System.out.println(messageBody);    
    }
}
