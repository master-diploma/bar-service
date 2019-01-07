package com.epam.edp.bar.listener;

import com.epam.edp.bar.config.RabbitMqConfig;
import com.epam.edp.bar.service.BarService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ listener of message queue.
 *
 * @author Roman_Martseniuk
 */
@Component
public class RabbitMqListener {

    private BarService barService;

    @Autowired
    public RabbitMqListener(BarService barService) {
        this.barService = barService;
    }

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listenBroker(String message) {
        barService.updateSetting(message);
    }
}
