import java.util.Objects;

public class EmployeeID {
    final private Integer id;
    public EmployeeID(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeID that = (EmployeeID) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
