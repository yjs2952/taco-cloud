package tacos.kitchen.messaging.kafka.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.kitchen.messaging.KitchenUI;

@Component
@RequiredArgsConstructor
public class OrderListener {
    private final KitchenUI ui;

    @KafkaListener(topics = "tacocloud.orders.topic")
    public void handle(Order order) {
        ui.displayOrder(order);
    }
}
