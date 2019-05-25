package ru.ravilova.employeedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ravilova.employeedb.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {



}
