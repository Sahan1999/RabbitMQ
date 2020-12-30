package com.adl.RabbitMQReceiveService;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitMqPracticeReceiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPracticeReceiveApplication.class, args);
	}

        public static final String QUEUE="queue1";
        public static final String EXCHANGE="exchange1";
        public static final String ROUTING_KEY="routingkey1";
        
        @Bean
        Queue queue(){
            return new Queue(QUEUE,false);
        }
        
        @Bean
        DirectExchange exchange(){
            return new DirectExchange(EXCHANGE);
        }
         
        @Bean
        Binding binding(Queue queue, DirectExchange exchange){
            return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
        }
        
        @Bean
        SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter){
            SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            container.setQueueNames(QUEUE);
            container.setMessageListener(messageListenerAdapter);
            return container;
        }
        
        @Bean
        MessageListenerAdapter listenerAdapter(ReceiveMessageHandler handler){
            return new MessageListenerAdapter(handler, "handleMessage");
        }
}
