package tacos.kitchen.messaging.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.Order;

@Component
@RequiredArgsConstructor
public class RabbitOrderReceiver {

    private final RabbitTemplate rabbit;
    private final MessageConverter converter;

//    public Order receiveOrder() {
//        Message message = rabbit.receive("tacocloud.orders", 30000);
//        return message != null ? (Order) converter.fromMessage(message) : null;
//    }

//    public Order receiveOrder() {
//        return (Order) rabbit.receiveAndConvert("tacocloud.order.queue");
//    }

    public Order receiveOrder() {
        return rabbit.receiveAndConvert("tacocloud.order.queue", new ParameterizedTypeReference<>() {
        });
    }
}
