package payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
