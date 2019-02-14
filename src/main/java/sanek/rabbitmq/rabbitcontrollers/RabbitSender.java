/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.rabbitmq.rabbitcontrollers;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sanek.rabbitmq.config.RabbitConfig;

/**
 *
 * @author Sanek
 */
@Component
public class RabbitSender {
    
//    @Autowired
//    private RabbitTemplate template;
    
   @Autowired
   private RabbitTemplate rabbitTemplate1;
   
   @Value("${jsa.rabbitmq.exchange}")
   private String exchange;
   
   @Value("${jsa.rabbitmq.routingkey}")
   private String routingKey;    

   @Value("${jsa.rabbitmq.queue}")
   private String queueName;    

//    @Autowired
//    private Queue queue;

    public void send(String message) {
        Date date = new Date();
        rabbitTemplate1.convertAndSend(exchange, routingKey, message);
        System.out.println(" - Sent " + message + " date: " + date);
    }
    
}
