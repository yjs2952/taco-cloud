package tacos.kitchen.messaging.jms.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.kitchen.messaging.KitchenUI;

@Component
@RequiredArgsConstructor
public class OrderListener {

    private final KitchenUI ui;

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }
}
