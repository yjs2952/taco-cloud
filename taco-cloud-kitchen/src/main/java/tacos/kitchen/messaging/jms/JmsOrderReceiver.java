package tacos.kitchen.messaging.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.kitchen.messaging.OrderReceiver;

@Profile("jms-template")
@Component("templateOrderReceiver")
@RequiredArgsConstructor
public class JmsOrderReceiver implements OrderReceiver {

    private final JmsTemplate jmsTemplate;

    @Override
    public Order receiveOrder() {
        return (Order) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
    }
}
