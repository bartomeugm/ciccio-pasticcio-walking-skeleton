package test;

import com.codurance.ciccio_pasticcio.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderApplicationServiceShould {

    private Repository orderRepository;
    private CustomerRepository customerRepository;
    private OrderValidator orderValidator;
    private CustomerID customerId;
    private OrderApplicationService orderApplicationService;

    @Before
    public void setUp() throws Exception {
        orderRepository = mock(OrderRepository.class);
        customerRepository = mock(LondonCustomerRepository.class);
        orderValidator = mock(OrderValidator.class);
        customerId = new CustomerID(1234);
        orderApplicationService = new OrderApplicationService(orderRepository, orderValidator, customerRepository);
    }

    @Test
    public void create_an_order_delegates_validation_and_persistance() throws CustomerNotExistsException {
        makeCustomerExist();
        Order order = insertOrder(getOrder()).entity;

        OrderRequest orderRequest = getOrderRequest();
        orderApplicationService.createOrder(orderRequest);

        InOrder inOrderVerification = inOrder(orderValidator, orderRepository);
        inOrderVerification.verify(orderValidator).validate(order);
        inOrderVerification.verify(orderRepository).insertOrder(order);
    }

    private OrderRequest getOrderRequest() {
        CustomerID customerId = new CustomerID(1234);
        Item item = new Item(1234);
        List<Item> itemList = new ArrayList<Item>() {{
            add(item);
        }};
        Products products = new Products(itemList);
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
        return orderRequest;
    }

    @Test
    public void create_an_order_returns_the_order_identifier() throws CustomerNotExistsException {
        makeCustomerExist();
        Persistable<Order> persistableOrder = insertOrder(getOrder());

        OrderRequest orderRequest = getOrderRequest();
        UUID id = orderApplicationService.createOrder(orderRequest);

        assertEquals(persistableOrder.identifier, id);
    }

    private OngoingStubbing<Boolean> makeCustomerExist() {
        return when(customerRepository.doesCustomerExists(customerId)).thenReturn(true);
    }

    private Persistable<Order> insertOrder(Order entity) {
        Persistable<Order> persistableOrder = Persistable.of(entity);
        when(orderRepository.insertOrder(entity)).thenReturn(persistableOrder);
        return persistableOrder;
    }

    private Order getOrder() {
        CustomerID customerId = new CustomerID(1234);
        Item item = new Item(1234);
        List<Item> itemList = new ArrayList<Item>() {{
            add(item);
        }};
        Products products = new Products(itemList);
        EmployeeID employeeId = new EmployeeID(123);
        ShippingDetails shippingDetails = new ShippingDetails(
                "Homer Simpson",
                "472, Evergreen terrace",
                "Springfield",
                "Oregon",
                "1234",
                "USA",
                true);

        Order order = new Order(employeeId, customerId, shippingDetails, products, new OrderID());
        return order;
    }
}
