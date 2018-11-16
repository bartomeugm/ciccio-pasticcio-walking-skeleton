package acceptance;

import com.codurance.ciccio_pasticcio.*;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AnOrderIsCreatedFeature {
    @Test
    public void an_order_is_created() {
        Repository orderRepository = mock(OrderRepository.class);
        Order order = new Order();

        Warehouse londonWarehouse = mock(LondonWarehouse.class);
        Item item = new Item("Breaking bad");
        londonWarehouse.getStockForItem(item);
        OrderApplicationService orderApplicationService = new OrderApplicationService(orderRepository, londonWarehouse);
        orderApplicationService.createOrder(order);

        verify(orderRepository).insertOrder(order);
    }
}
