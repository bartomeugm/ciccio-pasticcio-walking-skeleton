import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationServiceShould {

    @Test
    public void fail_if_no_data_provided_on_employee_creation() {

        assertThrows(IllegalArgumentException.class, () -> {
            new ApplicationService().addEmployee(null);
        });

    }
}
