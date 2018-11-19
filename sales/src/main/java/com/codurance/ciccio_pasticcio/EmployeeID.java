package com.codurance.ciccio_pasticcio;

import java.util.Objects;

public class EmployeeID {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeID that = (EmployeeID) o;
        return employeeNumber == that.employeeNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNumber);
    }

    private final int employeeNumber;

    public EmployeeID(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
