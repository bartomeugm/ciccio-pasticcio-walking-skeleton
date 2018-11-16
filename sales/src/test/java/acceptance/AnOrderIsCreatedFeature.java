package acceptance;

import com.codurance.ciccio_pasticcio.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AnOrderIsCreatedFeature {
    @Test
    public void an_order_is_created_when_the_customer_exists_and_the_product_is_not_discontinued_and_has_stock() {
        Repository orderRepository = mock(OrderRepository.class);
        Warehouse warehouse = mock(LondonWarehouse.class);
        CustomerService customerService = mock(LondonCustomerService.class);
        Catalog catalog = mock(LondonCatalog.class);
        CustomerId customerId = new CustomerId(1234);
        Item item = new Item("Breaking bad");
        List<Item> itemList = new ArrayList<Item>() {{
            add(item);
        }};
        Order order = new Order(customerId, itemList, "Infinity loop, 1, Cupertino");
        OrderValidator orderValidator = new OrderValidator(warehouse, catalog, customerService);

        OrderApplicationService orderApplicationService = new OrderApplicationService(orderRepository, orderValidator);
        orderApplicationService.createOrder(order);

        verify(orderValidator).validate(order);
        verify(orderRepository).insertOrder(order);
    }
}
