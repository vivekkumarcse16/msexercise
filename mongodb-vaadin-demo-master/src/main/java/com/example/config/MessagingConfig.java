package com.example.config;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

@Configuration
public class MessagingConfig {
	
	public static final String QUEUE= "p2p_service_queue";
	public static final String EXCHANGE= "p2p_service_exchange";
	public static final String ROUTING_KEY= "p2p_service_routingKey";
	
@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}
	
@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

@Bean
public Binding binding(Queue queue, TopicExchange exchange) {
	return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
}

@Bean
public MessageConverter converter() {
	return new Jackson2JsonMessageConverter();
}

@Bean
public AmqpTemplate template(ConnectionFactory connectionFactory) {
    final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(converter());
    return rabbitTemplate;
}


}
