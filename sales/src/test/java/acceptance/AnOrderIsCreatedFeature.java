package acceptance;

import com.codurance.ciccio_pasticcio.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AnOrderIsCreatedFeature {
    @Test
    @Ignore
    public void an_order_is_created_when_it_is_valid() throws CustomerNotExistsException {
        Repository orderRepository = mock(OrderRepository.class);
        Warehouse warehouse = mock(LondonWarehouse.class);
        CustomerRepository customerRepository = mock(LondonCustomerRepository.class);
        Catalog catalog = mock(LondonCatalog.class);
        CustomerID customerId = new CustomerID(1234);
        Item item = new Item(1234);
        List<Item> itemList = new ArrayList<Item>() {{
            add(item);
        }};
        Products products = new Products(itemList);
        when(customerRepository.doesCustomerExists(customerId)).thenReturn(true);
        EmployeeID employeeId = new EmployeeID(123);
        ShippingDetails shippingDetails = new ShippingDetails(
                "Homer Simpson",
                "472, Evergreen terrace",
                "Springfield",
                "Oregon",
                "1234",
                "USA",
                true);

        OrderRequest orderRequest = new OrderRequest(employeeId, customerId, shippingDetails, products);
        Order order = Order.from(orderRequest);

        OrderValidator orderValidator = new OrderValidator(warehouse, catalog);

        OrderApplicationService orderApplicationService = new OrderApplicationService(orderRepository, orderValidator, customerRepository);
        orderApplicationService.createOrder(orderRequest);

        verify(orderValidator).validate(order);
        verify(orderRepository).insertOrder(order);
    }
}
