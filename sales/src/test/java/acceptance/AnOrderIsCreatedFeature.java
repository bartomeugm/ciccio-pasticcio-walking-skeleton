package acceptance;

import com.codurance.ciccio_pasticcio.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AnOrderIsCreatedFeature {
    @Test
    public void an_order_is_created_when_it_is_valid() {
        Repository orderRepository = mock(OrderRepository.class);
        Warehouse warehouse = mock(LondonWarehouse.class);
        CustomerRepository customerRepository = mock(LondonCustomerRepository.class);
        Catalog catalog = mock(LondonCatalog.class);
        CustomerId customerId = new CustomerId(1234);
        Item item = new Item("Breaking bad");
        List<Item> itemList = new ArrayList<Item>() {{
            add(item);
        }};
        when(customerRepository.doesCustomerExists(customerId)).thenReturn(true);
        Order order = new Order(customerId, itemList, "Infinity loop, 1, Cupertino");
        OrderValidator orderValidator = new OrderValidator(warehouse, catalog, customerRepository);

        OrderApplicationService orderApplicationService = new OrderApplicationService(orderRepository, orderValidator, customerRepository);
        orderApplicationService.createOrder(order);

        verify(orderValidator).validate(order);
        verify(orderRepository).insertOrder(order);
    }
}
