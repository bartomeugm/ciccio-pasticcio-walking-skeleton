public class EmployeeID {
    final private Integer id;
    public EmployeeID(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString() ;
    }
}
