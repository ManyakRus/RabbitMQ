/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.rabbitmq.config.RabbitConfig;
import sanek.rabbitmq.rabbitcontrollers.RabbitReceiver;
import sanek.rabbitmq.rabbitcontrollers.RabbitSender;

/**
 *
 * @author Sanek
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private RabbitSender sender;
    
    @Autowired
    private RabbitReceiver receiver;
    
    @Test
    public void Send() {
        sender.send("Hello World!");
    }
    
    @Test
    public void Receive() {
        //String QUEUE_NAME = RabbitConfig.QUEUE_NAME;
        //receiver.receive();
    }
    
}
