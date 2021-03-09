package tacos.kitchen.messaging.rabbit.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.kitchen.messaging.KitchenUI;

@Component
@RequiredArgsConstructor
public class OrderListener {
    private final KitchenUI ui;

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receive(Order order) {
        ui.displayOrder(order);
    }
}
