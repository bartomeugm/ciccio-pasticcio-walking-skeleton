public class ApplicationService {
    public EmployeeID addEmployee(EmployeeDTO o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        return new EmployeeID(1234);
    }
}
