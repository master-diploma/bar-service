package com.epam.edp.bar.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for rabbitmq.
 *
 * @author Roman_Martseniuk
 **/
@Configuration
public class RabbitMqConfig {

    public static final String QUEUE = "foobar-queue";

    private String exchange;
    private String routingKey;

    public RabbitMqConfig(@Value("${spring.rabbitmq.exchange}") String exchange,
                          @Value("${spring.rabbitmq.routingkey}") String routingKey) {
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
