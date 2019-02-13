/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.rabbitmq.config;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sanek.rabbitmq.rabbitcontrollers.RabbitReceiver;
import sanek.rabbitmq.rabbitcontrollers.RabbitSender;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Sanek
 */
@Configuration
@EnableRabbit
public class RabbitConfig {

    public static String QUEUE_NAME = "test";
    
   @Value("${jsa.rabbitmq.queue}")
   private String queueName;
   
   @Value("${jsa.rabbitmq.exchange}")
   private String exchange;
   
   @Value("${jsa.rabbitmq.routingkey}")
   private String routingKey;    

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//            MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(QUEUE_NAME);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }
//    
//    @Bean
//    MessageListenerAdapter listenerAdapter(RabbitReceiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }    

   @Bean
   Queue queue() {
      return new Queue(queueName, false);
   }
    
   @Bean
   DirectExchange exchange() {
      return new DirectExchange(exchange);
   }

   @Bean
   Binding binding(Queue queue, DirectExchange exchange) {
      return BindingBuilder.bind(queue).to(exchange).with(routingKey);
   }
//   @Bean
//   public MessageConverter jsonMessageConverter() {
//      return new Jackson2JsonMessageConverter();
//   }

   
//   @Bean
//   public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//      final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//      //rabbitTemplate.setMessageConverter(jsonMessageConverter());
//      return rabbitTemplate;
//   }  

//    @Bean
//    public RabbitReceiver receiver() {
//        return new RabbitReceiver();
//    }
//
//    @Bean
//    public RabbitSender sender() {
//        return new RabbitSender();
//    }
}
