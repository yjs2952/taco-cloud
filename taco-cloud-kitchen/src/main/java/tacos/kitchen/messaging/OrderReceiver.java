package tacos.kitchen.messaging;

import tacos.Order;

public interface OrderReceiver {
    Order receiveOrder();
}
