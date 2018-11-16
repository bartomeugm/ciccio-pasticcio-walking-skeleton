import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationServiceShould {

    @Test
    public void fail_if_no_data_provided_on_employee_creation() {

        assertThrows(IllegalArgumentException.class, () -> {
            new ApplicationService().addEmployee(null);
        });
    }

    @Test
    public void return_id_of_created_employee() {
        ApplicationService applicationService = new ApplicationService();
        EmployeeDTO employeeData = new EmployeeDTO();
        EmployeeID employeeId = applicationService.addEmployee(employeeData);
        EmployeeID expectedId = new EmployeeID(1234);
        assertThat(employeeId, is(expectedId));
    }
}
