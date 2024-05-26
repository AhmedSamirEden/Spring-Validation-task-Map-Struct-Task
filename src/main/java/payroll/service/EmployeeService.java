package payroll.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import payroll.mapper.EmployeeMapper;
import payroll.mapper.EmployeeMapper;
import payroll.model.dto.EmployeeDto;
import payroll.model.entity.Employee;
import payroll.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    public EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder().id(employee.getId()).name(employee.getName()).role(employee.getRole()).build();
    }

    @Transactional
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employee = empRepo.findAll();
        List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
        for (Employee value : employee) {
            employeesDto.add(EmployeeMapper.INSTANCE.employeeToDto(value));
        }
        return employeesDto;
    }

    @Transactional
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.INSTANCE.employeeToDto(employee);
    }

    @Transactional
    public EmployeeDto AddEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        return EmployeeMapper.INSTANCE.employeeToDto(empRepo.save(employee));
    }

    @Transactional
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = empRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDto.getName());
        employee.setRole(employeeDto.getRole());
        return EmployeeMapper.INSTANCE.employeeToDto(employee);
    }

    public void deleteEmployee(Long id) {
        empRepo.deleteById(id);
    }
}
