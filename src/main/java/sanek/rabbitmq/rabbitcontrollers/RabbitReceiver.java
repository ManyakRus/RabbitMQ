/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.rabbitmq.rabbitcontrollers;

import java.util.Date;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sanek.rabbitmq.config.RabbitConfig;

/**
 *
 * @author Sanek
 */
@Component
//@RabbitListener(queues = "test")
public class RabbitReceiver {
    //@RabbitHandler
    @RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void receive(String msg) {
        //String QUEUE_NAME = RabbitConfig.QUEUE_NAME;
        Date date = new Date();
        System.out.println(" [x] Received: " + msg + " date: " + date);
    }
}
